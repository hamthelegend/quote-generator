package com.thebrownfoxx.quotegenerator.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thebrownfoxx.quotegenerator.logic.Quote
import com.thebrownfoxx.quotegenerator.logic.QuoteCategory
import com.thebrownfoxx.quotegenerator.ui.SampleQuote
import com.thebrownfoxx.quotegenerator.ui.screens.Orientation
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@Composable
fun HomeScreen(
    quoteOfTheDay: Quote,
    onShowQuote: (QuoteCategory) -> Unit,
    onShowFavoriteQuote: () -> Unit,
    hasFavoriteQuote: Boolean,
    modifier: Modifier = Modifier,
    orientation: Orientation = Orientation.Vertical,
) {
    when (orientation) {
        Orientation.Vertical -> VerticalHomeScreen(
            quoteOfTheDay = quoteOfTheDay,
            onShowQuote = onShowQuote,
            onShowFavoriteQuote = onShowFavoriteQuote,
            hasFavoriteQuote = hasFavoriteQuote,
            modifier = modifier,
        )
        Orientation.Horizontal -> HorizontalHomeScreen(
            quoteOfTheDay = quoteOfTheDay,
            onShowQuote = onShowQuote,
            onShowFavoriteQuote = onShowFavoriteQuote,
            hasFavoriteQuote = hasFavoriteQuote,
            modifier = modifier,
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    QuoteGeneratorTheme {
        HomeScreen(
            quoteOfTheDay = SampleQuote,
            onShowQuote = {},
            onShowFavoriteQuote = {},
            hasFavoriteQuote = true,
        )
    }
}