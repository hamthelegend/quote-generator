package com.thebrownfoxx.quotegenerator.ui.screens.quote

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thebrownfoxx.quotegenerator.logic.Quote
import com.thebrownfoxx.quotegenerator.ui.SampleQuote
import com.thebrownfoxx.quotegenerator.ui.screens.Orientation
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@Composable
fun QuoteScreen(
    quote: Quote,
    favorite: Boolean,
    onGoBack: () -> Unit,
    onRefresh: () -> Unit,
    onFavorite: () -> Unit,
    onUnfavorite: () -> Unit,
    modifier: Modifier = Modifier,
    orientation: Orientation = Orientation.Vertical,
) {
    BackHandler {
        onGoBack()
    }

    when (orientation) {
        Orientation.Vertical -> VerticalQuoteScreen(
            quote = quote,
            favorite = favorite,
            onGoBack = onGoBack,
            onRefresh = onRefresh,
            onFavorite = onFavorite,
            onUnfavorite = onUnfavorite,
            modifier = modifier,
        )

        Orientation.Horizontal -> HorizontalQuoteScreen(
            quote = quote,
            favorite = favorite,
            onGoBack = onGoBack,
            onRefresh = onRefresh,
            onFavorite = onFavorite,
            onUnfavorite = onUnfavorite,
            modifier = modifier,
        )
    }
}

@Preview
@Composable
fun QuoteScreenPreview() {
    QuoteGeneratorTheme {
        QuoteScreen(
            quote = SampleQuote,
            favorite = false,
            onGoBack = {},
            onRefresh = {},
            onFavorite = {},
            onUnfavorite = {},
        )
    }
}