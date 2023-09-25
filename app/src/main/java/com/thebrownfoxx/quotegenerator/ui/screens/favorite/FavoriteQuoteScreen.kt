package com.thebrownfoxx.quotegenerator.ui.screens.favorite

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thebrownfoxx.quotegenerator.logic.FavoriteQuote
import com.thebrownfoxx.quotegenerator.ui.SampleQuote
import com.thebrownfoxx.quotegenerator.ui.screens.Orientation
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme
import java.time.LocalDate

@Composable
fun FavoriteQuoteScreen(
    favoriteQuote: FavoriteQuote?,
    onGoBack: () -> Unit,
    onUnfavorite: () -> Unit,
    modifier: Modifier = Modifier,
    orientation: Orientation = Orientation.Vertical,
) {
    BackHandler {
        onGoBack()
    }

    when (orientation) {
        Orientation.Vertical -> VerticalFavoriteQuoteScreen(
            favoriteQuote = favoriteQuote,
            onGoBack = onGoBack,
            onUnfavorite = onUnfavorite,
            modifier = modifier,
        )

        Orientation.Horizontal -> HorizontalFavoriteQuoteScreen(
            favoriteQuote = favoriteQuote,
            onGoBack = onGoBack,
            onUnfavorite = onUnfavorite,
            modifier = modifier,
        )
    }
}

@Preview
@Composable
fun FavoriteQuoteScreenPreview() {
    QuoteGeneratorTheme {
        FavoriteQuoteScreen(
            favoriteQuote = FavoriteQuote(SampleQuote, LocalDate.now()),
            onGoBack = {},
            onUnfavorite = {},
        )
    }
}

@Preview
@Composable
fun NullFavoriteQuoteScreenPreview() {
    QuoteGeneratorTheme {
        FavoriteQuoteScreen(
            favoriteQuote = null,
            onGoBack = {},
            onUnfavorite = {},
        )
    }
}