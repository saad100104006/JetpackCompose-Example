package com.finxp.account.util

import android.os.Build
import java.util.*

class Currency {
    companion object {}
}

fun Currency.Companion.getCurrencySign(code: String): String {
    val currency = java.util.Currency.getInstance(code)
    var sign = ""
    sign = when {
        Build.VERSION.SDK_INT >=24 -> {
            currency.getSymbol(Locale.getDefault(Locale.Category.DISPLAY));
        }
        else ->  {
            currency.getSymbol(Locale.UK)
        }
    }

    return sign
}