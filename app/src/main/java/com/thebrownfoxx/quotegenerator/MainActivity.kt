package com.thebrownfoxx.quotegenerator

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.core.view.WindowCompat
import com.thebrownfoxx.quotegenerator.ui.screens.home.HomeScreen
import com.thebrownfoxx.quotegenerator.ui.screens.quotescreen.QuoteScreen
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme
import com.thebrownfoxx.quotegenerator.ui.transitions.sharedXAxis
import com.thebrownfoxx.quotegenerator.ui.transitions.sharedZAxis

class MainActivity : ComponentActivity() {

    var onDateChange: (() -> Unit)? = null

    private val dateChangedReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val action = intent?.action
            if (action == Intent.ACTION_DATE_CHANGED) {
                onDateChange?.invoke()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val viewModel: MainViewModel by viewModels()
        onDateChange = viewModel::onDateChange

        IntentFilter(Intent.ACTION_DATE_CHANGED).also {
            registerReceiver(dateChangedReceiver, it)
        }

        setContent {
            QuoteGeneratorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    viewModel.apply {
                        AnimatedContent(
                            targetState = quote,
                            transitionSpec = {
                                sharedZAxis(targetState != null)
                            },
                            contentKey = { it != null },
                            modifier = Modifier.fillMaxSize()
                        ) { quote ->
                            if (quote == null) {
                                HomeScreen(
                                    quoteOfTheDay = quoteOfTheDay,
                                    onShowQuoteCategory = ::onShowQuote,
                                    onShowFavoriteQuote = ::onShowFavoriteQuote,
                                )
                            } else {
                                QuoteScreen(
                                    quote = quote,
                                    favorite = false,
                                    onClose = ::onHideQuote,
                                    onRefresh = ::onRefreshQuote,
                                    onFavorite = ::onFavoriteQuote,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}