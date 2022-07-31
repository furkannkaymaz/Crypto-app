package com.cryptoApp.utils.model

import com.cryptoApp.R
import com.cryptoApp.utils.extensions.string

enum class ErrorModel(val code: String) {
    FAIL(string(R.string.error)),
}

enum class ErrorType(val code: String) {
    NETWORK(string(R.string.networkError)),
    API(string(R.string.serverError)),
}