package com.thebrownfoxx.quotegenerator.logic

import java.time.LocalDate

data class Quote(
    val value: String,
    val category: QuoteCategory,
)

data class FavoriteQuote(
    val quote: Quote,
    val dateFavorited: LocalDate,
)