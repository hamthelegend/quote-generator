package com.thebrownfoxx.quotegenerator.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import com.thebrownfoxx.quotegenerator.MainViewModel
import com.thebrownfoxx.quotegenerator.ui.screens.favorite.FavoriteQuoteScreen
import com.thebrownfoxx.quotegenerator.ui.screens.home.HomeScreen
import com.thebrownfoxx.quotegenerator.ui.screens.quote.QuoteScreen
import com.thebrownfoxx.quotegenerator.ui.transitions.sharedXAxis

@Composable
fun Navigator(
    viewModel: MainViewModel,
    windowSizeClass: WindowSizeClass,
    modifier: Modifier = Modifier,
) {
    val orientation =
        if (windowSizeClass.widthSizeClass >= WindowWidthSizeClass.Medium) Orientation.Horizontal
        else Orientation.Vertical

    viewModel.apply {
        val favoriteQuote by favoriteQuote.collectAsState(initial = null)
        val density = LocalDensity.current

        AnimatedContent(
            targetState = quote to showFavoriteQuote,
            transitionSpec = {
                val (quote, showFavoriteQuote) = targetState
                density.sharedXAxis(forward = showFavoriteQuote || quote != null)
            },
            contentKey = { (quote, showFavoriteQuote) ->
                quote != null || showFavoriteQuote
            },
            modifier = modifier,
        ) { (quote, showFavoriteQuote) ->
            when {
                showFavoriteQuote -> {
                    FavoriteQuoteScreen(
                        favoriteQuote = favoriteQuote,
                        onGoBack = ::onHideFavoriteQuote,
                        onUnfavorite = ::onUnfavoriteQuote,
                        orientation = orientation,
                    )
                }

                quote == null -> {
                    HomeScreen(
                        quoteOfTheDay = quoteOfTheDay,
                        onShowQuote = ::onChangeCategory,
                        onShowFavoriteQuote = ::onShowFavoriteQuote,
                        hasFavoriteQuote = favoriteQuote != null,
                        orientation = orientation,
                    )
                }

                else -> {
                    QuoteScreen(
                        quote = quote,
                        favorite = favoriteQuote?.quote == quote,
                        onGoBack = ::onHideQuote,
                        onRefresh = ::onRefreshQuote,
                        onFavorite = ::onFavoriteQuote,
                        onUnfavorite = ::onUnfavoriteQuote,
                        orientation = orientation,
                    )
                }
            }
        }
    }
}