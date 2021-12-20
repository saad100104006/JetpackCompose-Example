package com.finxp.account.presentation.screens.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.finxp.account.R
import com.finxp.account.presentation.common.CircularIndeterminateProgressBar
import com.finxp.account.presentation.common.CommonText
import com.finxp.account.presentation.theme.FinXpTheme
import com.finxp.account.presentation.theme.LightGrayColor
import com.finxp.account.util.getCurrencySign
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment: Fragment() {

    private val viewModel: AccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val account = viewModel.accountBalance.value
                val loading = viewModel.loading.value

                FinXpTheme{
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 30.dp, end = 30.dp, top = 20.dp, bottom = 20.dp)
                    ) {
                        CircularIndeterminateProgressBar(isDisplayed = loading, 0.3f)
                        if (!loading) {

                            Column(
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.verticalScroll(state = rememberScrollState())
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(
                                            id = R.drawable.fine_xp_logo
                                        ),
                                        contentDescription = "App Logo",
                                        modifier = Modifier.size(150.dp)
                                    )
                                }
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.fillMaxWidth()
                                )
                                {
                                    CommonText(
                                        text = "Account Balance",
                                        fontSize = 34.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = LightGrayColor
                                    ) {}
                                    CommonText(
                                        text = getCurrencySign(account?.currency.toString()) + account?.balance.toString(),
                                        fontSize = 34.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = LightGrayColor
                                    ) {}
                                }
                            }
                        }

                    }
                }
            }
        }
    }

}