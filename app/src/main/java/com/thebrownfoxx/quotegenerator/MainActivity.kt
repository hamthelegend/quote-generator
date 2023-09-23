package com.thebrownfoxx.quotegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.core.view.WindowCompat
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            QuoteGeneratorTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Navigator(viewModel)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onUpdateQuoteOfTheDay()
    }
}