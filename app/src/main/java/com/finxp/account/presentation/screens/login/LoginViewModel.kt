package com.finxp.account.presentation.screens.login

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.finxp.account.R
import com.finxp.account.repository.FinXpRepository
import com.finxp.account.util.TAG
import com.finxp.account.util.TOKEN_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel
@Inject
constructor(
    private  val repository: FinXpRepository,
    private val sharedPref: SharedPreferences
) : ViewModel() {

    val loading = mutableStateOf(false)

    fun login(
        email: String,
        password: String,
        navController: NavController,
        context: Context
    ) {
        viewModelScope.launch {
            try {
                loading.value = true
                getToken(email = email, password = password);
                loading.value = false
                navController.navigate(R.id.account_screen);
            } catch (e: Exception) {
                Log.e(TAG, "login: Exception: ${e}, ${e.cause}")
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show();
                e.printStackTrace()
                loading.value = false
            }
        }
    }

    private suspend fun getToken(
        email: String,
        password: String,
    ) {
        val result = repository.getToken(
            email = email,
            password = password
        );
        saveToken(result.tokenType +" "+ result.accessToken);
    }

    private fun saveToken(token: String) {
        sharedPref.edit().apply{
            putString(TOKEN_KEY, token).apply()
        }
    }

}