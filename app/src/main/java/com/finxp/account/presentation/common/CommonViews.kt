package com.finxp.account.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finxp.account.presentation.theme.LightGrayColor
import com.finxp.account.presentation.theme.PinkColor
import com.finxp.account.presentation.theme.SkinColor

@Composable
fun CommonText(
    text: String,
    color: Color = Color.Black,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    function: () -> Unit
) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        modifier = Modifier.clickable {
            function()
        }
    )
}

@Composable
fun CommonLoginButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        PinkColor, SkinColor
                    )
                ),
                RoundedCornerShape(20.dp)
            )
            .height(58.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        onClick = { onClick() },
        elevation = ButtonDefaults.elevation(0.dp, 0.dp)
    ) {
        Text(text = text, fontSize = 20.sp, color = Color.White)
    }
}


@Composable
fun CommonTextField(
    text: String,
    placeholder: String,
    isPasswordTextField: Boolean,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = text,
        onValueChange = { onValueChange(it) },
        label = { Text(text = placeholder, color = LightGrayColor) },
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = PinkColor,
            cursorColor = LightGrayColor
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = if (isPasswordTextField) PasswordVisualTransformation()
        else VisualTransformation.None
    )

}