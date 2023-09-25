package com.thebrownfoxx.quotegenerator.ui.screens.quote

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.thebrownfoxx.quotegenerator.ui.components.BackButton
import com.thebrownfoxx.quotegenerator.ui.components.Quote
import com.thebrownfoxx.quotegenerator.ui.components.icon
import com.thebrownfoxx.quotegenerator.ui.components.iconContentDescription
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
) {
    BackHandler {
        onGoBack()
    }

    val label = stringResource(
        when (quote.category) {
            QuoteCategory.Love -> R.string.love_quote
            QuoteCategory.Inspirational -> R.string.inspirational_quote
            QuoteCategory.Funny -> R.string.funny_quote
        }
    )

    Surface {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            modifier = modifier
                .padding(24.dp)
                .fillMaxSize()
                .systemBarsPadding(),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                Quote(
                    quote = quote.value,
                    author = quote.author,
                    icon = quote.category.icon,
                    iconContentDescription = quote.category.iconContentDescription,
                    label = label,
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(),
            ) {
                BackButton(onClick = onGoBack)
                RefreshButton(onClick = onRefresh)
                FavoriteButton(
                    favorite = favorite,
                    onClick = if (favorite) onUnfavorite else onFavorite
                )
            }
        }
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