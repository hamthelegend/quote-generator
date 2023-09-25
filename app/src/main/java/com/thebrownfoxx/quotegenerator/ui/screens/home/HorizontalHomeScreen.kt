package com.thebrownfoxx.quotegenerator.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.thebrownfoxx.quotegenerator.ui.components.iconContentDescription
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@Composable
fun HorizontalHomeScreen(
    quoteOfTheDay: Quote,
    onShowQuote: (QuoteCategory) -> Unit,
    onShowFavoriteQuote: () -> Unit,
    hasFavoriteQuote: Boolean,
    modifier: Modifier = Modifier,
) {
    Surface {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),
            modifier = Modifier.padding(horizontal = 24.dp),
        ) {
            Spacer(modifier = Modifier.width(24.dp))
            Column(
                modifier = modifier
                    .weight(1f)
                    .verticalScroll(state = rememberScrollState())
                    .systemBarsPadding(),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Quote(
                    quote = quoteOfTheDay.value,
                    icon = quoteOfTheDay.category.icon,
                    iconContentDescription = quoteOfTheDay.category.iconContentDescription,
                    label = stringResource(R.string.quote_of_the_day),
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
            Column(
                modifier = modifier
                    .width(IntrinsicSize.Max)
                    .verticalScroll(state = rememberScrollState())
                    .systemBarsPadding(),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                for (category in QuoteCategory.values()) {
                    QuoteCategoryButton(
                        category = category,
                        onClick = { onShowQuote(category) },
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
                FavoriteQuoteButton(
                    onClick = onShowFavoriteQuote,
                    modifier = Modifier.fillMaxWidth(),
                    enabled = hasFavoriteQuote,
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Preview(device = "spec:parent=pixel_5,orientation=landscape")
@Composable
fun HorizontalHomeScreenPreview() {
    QuoteGeneratorTheme {
        HorizontalHomeScreen(
            quoteOfTheDay = SampleQuote,
            onShowQuote = {},
            onShowFavoriteQuote = {},
            hasFavoriteQuote = true,
        )
    }
}