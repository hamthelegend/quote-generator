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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.logic.FavoriteQuote
import com.thebrownfoxx.quotegenerator.ui.SampleQuote
import com.thebrownfoxx.quotegenerator.ui.components.CloseButton
import com.thebrownfoxx.quotegenerator.ui.components.Quote
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorIcons
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme
import java.time.LocalDate

@Composable
fun FavoriteQuoteScreen(
    favoriteQuote: FavoriteQuote?,
    onClose: () -> Unit,
    onUnfavorite: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BackHandler {
        onClose()
    }

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
                    quote = favoriteQuote?.quote?.value
                        ?: stringResource(R.string.no_favorite_quote_guide),
                    icon = QuoteGeneratorIcons.Star,
                    iconContentDescription = stringResource(id = R.string.star_icon),
                    label = stringResource(id = R.string.favorite_quote),
                )
                if (favoriteQuote != null) {
                    Text(text = favoriteQuote.dateFavorited.toEpochDay().toString())
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(),
            ) {
                CloseButton(onClick = onClose)
                if (favoriteQuote != null) {
                    UnfavoriteButton(onClick = onUnfavorite)
                    Spacer(modifier = Modifier.padding(32.dp))
                }
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
            onClose = {},
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
            onClose = {},
            onUnfavorite = {},
        )
    }
}