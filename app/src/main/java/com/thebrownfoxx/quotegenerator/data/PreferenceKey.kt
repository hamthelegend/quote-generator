package com.thebrownfoxx.quotegenerator.data

import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceKey {
    val FavoriteQuote = stringPreferencesKey("favorite_quote")
    val FavoriteQuoteCategory = stringPreferencesKey("favorite_quote_category")
    val DateQuoteFavorited = longPreferencesKey("date_quote_favorited")
}