package com.thebrownfoxx.quotegenerator.ui.screens.favorite

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.logic.FavoriteQuote
import com.thebrownfoxx.quotegenerator.ui.SampleQuote
import com.thebrownfoxx.quotegenerator.ui.components.BackButton
import com.thebrownfoxx.quotegenerator.ui.components.Quote
import com.thebrownfoxx.quotegenerator.ui.extension.formatted
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorIcons
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme
import java.time.LocalDate

@Composable
fun FavoriteQuoteScreen(
    favoriteQuote: FavoriteQuote?,
    onGoBack: () -> Unit,
    onUnfavorite: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BackHandler {
        onGoBack()
    }

    Surface {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            modifier = modifier
                .padding(24.dp)
                .fillMaxSize()
                .systemBarsPadding(),
        ) {
            Quote(
                quote = favoriteQuote?.quote?.value
                    ?: stringResource(R.string.no_favorite_quote_guide),
                author = favoriteQuote?.quote?.author,
                icon = QuoteGeneratorIcons.Star,
                iconContentDescription = stringResource(id = R.string.star_icon),
                label = favoriteQuote?.dateFavorited?.formatted()
                    ?: stringResource(id = R.string.favorite_quote),
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .weight(1f)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(),
            ) {
                BackButton(onClick = onGoBack)
                UnfavoriteButton(
                    onClick = onUnfavorite,
                    enabled = favoriteQuote != null,
                )
                Spacer(modifier = Modifier.padding(32.dp))
            }
        }
    }
}

@Preview
@Composable
fun FavoriteQuoteScreenPreview() {
    QuoteGeneratorTheme {
        FavoriteQuoteScreen(
            favoriteQuote = FavoriteQuote(SampleQuote, LocalDate.now()),
            onGoBack = {},
            onUnfavorite = {},
        )
    }
}

@Preview
@Composable
fun NullFavoriteQuoteScreenPreview() {
    QuoteGeneratorTheme {
        FavoriteQuoteScreen(
            favoriteQuote = null,
            onGoBack = {},
            onUnfavorite = {},
        )
    }
}