package com.finxp.account.presentation.screens.account

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finxp.account.domain.model.Account
import com.finxp.account.repository.FinXpRepository
import com.finxp.account.util.TAG
import com.finxp.account.util.TOKEN_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel
@Inject
constructor(
    private  val repository: FinXpRepository,
    private val sharedPref: SharedPreferences
): ViewModel() {

    val accountBalance: MutableState<Account?> = mutableStateOf(null);
    val loading = mutableStateOf(false)

    init {
        loading.value = true
        Log.d(TAG, "Shared prefs call");
        val token = sharedPref.getString(TOKEN_KEY, "");
        Log.d(TAG, "Shared prefs value:  $token");
        if (token != null) {
            viewModelScope.launch {
                getAccountBalance(token = token)
            }
        }
    }

    private suspend fun getAccountBalance(token: String) {
        try {
            val balance = repository.getBalance(token = token);
            Log.d(TAG, balance.currency);
            accountBalance.value = balance;
            loading.value = false
        } catch (e: Exception) {
            Log.e(TAG, "balance call: Exception: ${e}, ${e.cause}")
            e.printStackTrace()
            loading.value = false
        }
    }



}