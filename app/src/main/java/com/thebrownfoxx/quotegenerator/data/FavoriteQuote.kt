package com.thebrownfoxx.quotegenerator.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.thebrownfoxx.quotegenerator.logic.FavoriteQuote
import com.thebrownfoxx.quotegenerator.logic.Quote
import com.thebrownfoxx.quotegenerator.logic.QuoteCategory
import kotlinx.coroutines.flow.map
import java.time.LocalDate

val Context.favoriteQuote
    get() = dataStore.data.map { preferences ->
        val favoriteQuote = preferences[PreferenceKey.FavoriteQuote]
        val category = preferences[PreferenceKey.FavoriteQuoteCategory]
            ?.let { QuoteCategory.valueOf(it) }
        val dateFavorited = preferences[PreferenceKey.DateQuoteFavorited]
            ?.let { LocalDate.ofEpochDay(it) }
        if (favoriteQuote != null && category != null && dateFavorited != null) {
            FavoriteQuote(
                quote = Quote(favoriteQuote, category),
                dateFavorited = dateFavorited,
            )
        } else null
    }

suspend fun Context.setFavoriteQuote(favoriteQuote: FavoriteQuote?) {
    dataStore.edit { preferences ->
        if (favoriteQuote != null) {
            preferences[PreferenceKey.FavoriteQuote] = favoriteQuote.quote.value
            preferences[PreferenceKey.FavoriteQuoteCategory] = favoriteQuote.quote.category.name
            preferences[PreferenceKey.DateQuoteFavorited] = favoriteQuote.dateFavorited.toEpochDay()
        } else {
            preferences.remove(PreferenceKey.FavoriteQuote)
            preferences.remove(PreferenceKey.FavoriteQuoteCategory)
            preferences.remove(PreferenceKey.DateQuoteFavorited)
        }
    }
}