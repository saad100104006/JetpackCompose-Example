package com.finxp.account.presentation.screens.login

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.finxp.account.R
import com.finxp.account.presentation.common.CircularIndeterminateProgressBar
import com.finxp.account.presentation.common.CommonLoginButton
import com.finxp.account.presentation.common.CommonText
import com.finxp.account.presentation.common.CommonTextField
import com.finxp.account.presentation.theme.LightGrayColor

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel, context: Context) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val loading = viewModel.loading.value

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp, top = 20.dp, bottom = 20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(state = rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(20.dp))
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
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                CommonText(text = "Md. Tanvir Hossain", fontSize = 14.sp, fontWeight = FontWeight.Bold,
                    color = LightGrayColor) {}
                Spacer(modifier = Modifier.height(5.dp))
                CommonText(
                    text = "Sign in to continue!",
                    fontSize = 28.sp,
                    color = LightGrayColor
                ) {}
            }
            Spacer(modifier = Modifier.height(30.dp))
            CommonTextField(
                text = email,
                placeholder = "Email",
                onValueChange = { email = it },
                isPasswordTextField = false
            )
            Spacer(modifier = Modifier.height(16.dp))
            CommonTextField(
                text = password,
                placeholder = "Password",
                onValueChange = { password = it },
                isPasswordTextField = true
            )
            Spacer(modifier = Modifier.height(20.dp))
            if (!loading) {
                CommonLoginButton(text = "Login", modifier = Modifier.fillMaxWidth()) {
                    viewModel.login(
                        email = email,
                        password = password,
                        navController = navController,
                        context = context)
                }
            }
            CircularIndeterminateProgressBar(isDisplayed = loading, 0.3f)
            Spacer(modifier = Modifier.height(24.dp))
            Spacer(modifier = Modifier.weight(0.4f))

        }
    }
}