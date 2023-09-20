package com.thebrownfoxx.quotegenerator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.thebrownfoxx.quotegenerator.logic.Quote
import com.thebrownfoxx.quotegenerator.logic.QuoteCategory
import com.thebrownfoxx.quotegenerator.logic.getQuoteOfTheDay

class MainViewModel : ViewModel() {
    var quoteOfTheDay by mutableStateOf(getQuoteOfTheDay())
        private set

    var quote by mutableStateOf<Quote?>(null)
        private set

    fun onDateChange() {
        quoteOfTheDay = getQuoteOfTheDay()
    }

    fun onShowQuote(category: QuoteCategory) {
        quote = category.getRandomQuote()
    }

    fun onRefreshQuote() {
        quote = quote?.category?.getRandomQuote(previousQuote = quote)
    }

    fun onHideQuote() {
        quote = null
    }

    fun onFavoriteQuote() {
        TODO()
    }

    fun onShowFavoriteQuote() {
        TODO()
    }
}