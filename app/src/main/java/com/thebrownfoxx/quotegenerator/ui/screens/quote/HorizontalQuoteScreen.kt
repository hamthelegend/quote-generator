package com.thebrownfoxx.quotegenerator.ui.screens.quote

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.thebrownfoxx.quotegenerator.ui.components.BackButton
import com.thebrownfoxx.quotegenerator.ui.components.Quote
import com.thebrownfoxx.quotegenerator.ui.components.icon
import com.thebrownfoxx.quotegenerator.ui.components.iconContentDescription
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@Composable
fun HorizontalQuoteScreen(
    quote: Quote,
    favorite: Boolean,
    onGoBack: () -> Unit,
    onRefresh: () -> Unit,
    onFavorite: () -> Unit,
    onUnfavorite: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val label = stringResource(
        when (quote.category) {
            QuoteCategory.Love -> R.string.love_quote
            QuoteCategory.Inspirational -> R.string.inspirational_quote
            QuoteCategory.Funny -> R.string.funny_quote
        }
    )

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
                    quote = quote.value,
                    author = quote.author,
                    icon = quote.category.icon,
                    iconContentDescription = quote.category.iconContentDescription,
                    label = label,
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
            Column(
                modifier = modifier.systemBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                FavoriteButton(
                    favorite = favorite,
                    onClick = if (favorite) onUnfavorite else onFavorite
                )
                RefreshButton(onClick = onRefresh)
                BackButton(onClick = onGoBack)
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Preview(device = "spec:parent=pixel_5,orientation=landscape")
@Composable
fun HorizontalQuoteScreenPreview() {
    QuoteGeneratorTheme {
        HorizontalQuoteScreen(
            quote = SampleQuote,
            favorite = false,
            onGoBack = {},
            onRefresh = {},
            onFavorite = {},
            onUnfavorite = {},
        )
    }
}