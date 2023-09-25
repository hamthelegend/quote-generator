package com.thebrownfoxx.quotegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.view.WindowCompat
import com.thebrownfoxx.quotegenerator.ui.screens.Navigator
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            QuoteGeneratorTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Navigator(
                        viewModel = viewModel,
                        windowSizeClass = windowSizeClass,
                    )
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onUpdateQuoteOfTheDay()
    }
}