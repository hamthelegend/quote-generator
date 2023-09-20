package com.thebrownfoxx.quotegenerator.ui.components

import androidx.compose.material.icons.twotone.AutoAwesome
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material.icons.twotone.SentimentVerySatisfied
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.logic.QuoteCategory
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorIcons

val QuoteCategory.icon get() = when (this) {
    QuoteCategory.Love -> QuoteGeneratorIcons.Favorite
    QuoteCategory.Inspirational -> QuoteGeneratorIcons.AutoAwesome
    QuoteCategory.Funny -> QuoteGeneratorIcons.SentimentVerySatisfied
}

val QuoteCategory.iconContentDescriptionResourceId get() = when (this) {
    QuoteCategory.Love -> R.string.heart_icon
    QuoteCategory.Inspirational -> R.string.inspiration_icon
    QuoteCategory.Funny -> R.string.laughing_face_icon
}