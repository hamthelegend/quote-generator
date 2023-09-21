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
import com.thebrownfoxx.quotegenerator.ui.components.CloseButton
import com.thebrownfoxx.quotegenerator.ui.components.Quote
import com.thebrownfoxx.quotegenerator.ui.components.icon
import com.thebrownfoxx.quotegenerator.ui.components.iconContentDescriptionResourceId
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@Composable
fun QuoteScreen(
    quote: Quote,
    favorite: Boolean,
    onClose: () -> Unit,
    onRefresh: () -> Unit,
    onFavorite: () -> Unit,
    onUnfavorite: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BackHandler {
        onClose()
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
                    icon = quote.category.icon,
                    iconContentDescription = stringResource(
                        quote.category.iconContentDescriptionResourceId
                    ),
                    label = label,
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(),
            ) {
                CloseButton(onClick = onClose)
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
            onClose = {},
            onRefresh = {},
            onFavorite = {},
            onUnfavorite = {},
        )
    }
}