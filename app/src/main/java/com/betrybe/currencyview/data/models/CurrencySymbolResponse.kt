package com.betrybe.currencyview.data.models

data class CurrencySymbolResponse(
    val succsess: Boolean,
    val symbols: Map<String, String>
)
