package com.thebrownfoxx.quotegenerator.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.logic.Quote
import com.thebrownfoxx.quotegenerator.logic.QuoteCategory
import com.thebrownfoxx.quotegenerator.ui.SampleQuote
import com.thebrownfoxx.quotegenerator.ui.components.Quote
import com.thebrownfoxx.quotegenerator.ui.components.icon
import com.thebrownfoxx.quotegenerator.ui.components.iconContentDescriptionResourceId
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@Composable
fun HomeScreen(
    quoteOfTheDay: Quote,
    onShowQuoteCategory: (QuoteCategory) -> Unit,
    onShowFavoriteQuote: () -> Unit,
    hasFavoriteQuote: Boolean,
    modifier: Modifier = Modifier,
) {
    Surface {
        Column(
            modifier = modifier
                .padding(24.dp)
                .fillMaxSize()
                .systemBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        ) {
            Quote(
                quote = quoteOfTheDay.value,
                icon = quoteOfTheDay.category.icon,
                iconContentDescription = stringResource(
                    quoteOfTheDay.category.iconContentDescriptionResourceId
                ),
                label = stringResource(R.string.quote_of_the_day),
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .weight(1f),
            )
            for (category in QuoteCategory.values()) {
                QuoteCategoryButton(
                    category = category,
                    onClick = { onShowQuoteCategory(category) },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            FavoriteQuoteButton(
                onClick = onShowFavoriteQuote,
                modifier = Modifier.fillMaxWidth(),
                enabled = hasFavoriteQuote,
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    QuoteGeneratorTheme {
        HomeScreen(
            quoteOfTheDay = SampleQuote,
            onShowQuoteCategory = {},
            onShowFavoriteQuote = {},
            hasFavoriteQuote = true,
        )
    }
}