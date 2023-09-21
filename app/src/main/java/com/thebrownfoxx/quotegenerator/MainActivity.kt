package com.thebrownfoxx.quotegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.thebrownfoxx.quotegenerator.ui.screens.favorite.FavoriteQuoteScreen
import com.thebrownfoxx.quotegenerator.ui.screens.home.HomeScreen
import com.thebrownfoxx.quotegenerator.ui.screens.quote.QuoteScreen
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme
import com.thebrownfoxx.quotegenerator.ui.transitions.sharedZAxis

class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            viewModel.apply {
                val favoriteQuote by favoriteQuote.collectAsState(null)

                QuoteGeneratorTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AnimatedContent(
                            targetState = quote to showFavoriteQuote,
                            transitionSpec = {
                                val (quote, showFavoriteQuote) = targetState
                                sharedZAxis(forward = showFavoriteQuote || quote != null)
                            },
                            contentKey = { (quote, showFavoriteQuote) ->
                                quote != null || showFavoriteQuote
                            },
                            modifier = Modifier.fillMaxSize(),
                        ) { (quote, showFavoriteQuote) ->
                            when {
                                showFavoriteQuote -> {
                                    FavoriteQuoteScreen(
                                        favoriteQuote = favoriteQuote,
                                        onClose = ::onHideFavoriteQuote,
                                        onUnfavorite = ::onUnfavoriteQuote,
                                    )
                                }

                                quote == null -> {
                                    HomeScreen(
                                        quoteOfTheDay = quoteOfTheDay,
                                        onShowQuoteCategory = ::onShowQuote,
                                        onShowFavoriteQuote = ::onShowFavoriteQuote,
                                        hasFavoriteQuote = favoriteQuote != null,
                                    )
                                }

                                else -> {
                                    QuoteScreen(
                                        quote = quote,
                                        favorite = favoriteQuote?.quote == quote,
                                        onClose = ::onHideQuote,
                                        onRefresh = ::onRefreshQuote,
                                        onFavorite = ::onFavoriteQuote,
                                        onUnfavorite = ::onUnfavoriteQuote,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onUpdateQuoteOfTheDay()
    }
}