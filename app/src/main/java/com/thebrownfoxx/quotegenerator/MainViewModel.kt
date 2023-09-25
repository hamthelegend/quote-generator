package com.thebrownfoxx.quotegenerator

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.thebrownfoxx.quotegenerator.data.favoriteQuote
import com.thebrownfoxx.quotegenerator.data.setFavoriteQuote
import com.thebrownfoxx.quotegenerator.logic.FavoriteQuote
import com.thebrownfoxx.quotegenerator.logic.Quote
import com.thebrownfoxx.quotegenerator.logic.QuoteCategory
import com.thebrownfoxx.quotegenerator.logic.getQuoteOfTheDay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val favoriteQuote = getApplication<Application>().applicationContext.favoriteQuote

    var quoteOfTheDay by mutableStateOf(getQuoteOfTheDay())
        private set

    var quote by mutableStateOf<Quote?>(null)
        private set

    var showFavoriteQuote by mutableStateOf(false)
        private set

    fun onUpdateQuoteOfTheDay() {
        quoteOfTheDay = getQuoteOfTheDay()
    }

    fun onShowQuote(category: QuoteCategory) {
        quote = category.getRandomQuote()
    }

    fun onRefreshQuote() {
        quote = quote?.category?.getRandomQuote(previousQuote = quote)
    }

    fun onChangeCategory(category: QuoteCategory) {
        if (category != quote?.category) quote = category.getRandomQuote()
    }

    fun onHideQuote() {
        quote = null
    }

    fun onFavoriteQuote() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val favoriteQuote = quote?.let { FavoriteQuote(it, LocalDate.now()) }
                getApplication<Application>().applicationContext.setFavoriteQuote(favoriteQuote)
            }
        }
    }

    fun onUnfavoriteQuote() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getApplication<Application>().applicationContext.setFavoriteQuote(null)
            }
        }
    }

    fun onShowFavoriteQuote() {
        showFavoriteQuote = true
    }

    fun onHideFavoriteQuote() {
        showFavoriteQuote = false
    }
}