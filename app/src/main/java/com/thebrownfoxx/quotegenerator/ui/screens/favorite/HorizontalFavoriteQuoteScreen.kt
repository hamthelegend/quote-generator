package com.thebrownfoxx.quotegenerator.ui.screens.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun HorizontalFavoriteQuoteScreen(
    favoriteQuote: FavoriteQuote?,
    onGoBack: () -> Unit,
    onUnfavorite: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .verticalScroll(state = rememberScrollState())
                    .systemBarsPadding(),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Quote(
                    quote = favoriteQuote?.quote?.value
                        ?: stringResource(R.string.no_favorite_quote_guide),
                    author = favoriteQuote?.quote?.author,
                    icon = QuoteGeneratorIcons.Star,
                    iconContentDescription = stringResource(id = R.string.star_icon),
                    label = favoriteQuote?.dateFavorited?.formatted()
                        ?: stringResource(id = R.string.favorite_quote),
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
            Column(
                modifier = modifier.systemBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Spacer(modifier = Modifier.size(72.dp))
                UnfavoriteButton(
                    onClick = onUnfavorite,
                    enabled = favoriteQuote != null,
                )
                BackButton(onClick = onGoBack)
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Preview(device = "spec:parent=pixel_5,orientation=landscape")
@Composable
fun HorizontalFavoriteQuoteScreenPreview() {
    QuoteGeneratorTheme {
        HorizontalFavoriteQuoteScreen(
            favoriteQuote = FavoriteQuote(SampleQuote, LocalDate.now()),
            onGoBack = {},
            onUnfavorite = {},
        )
    }
}

@Preview(device = "spec:parent=pixel_5,orientation=landscape")
@Composable
fun NullHorizontalFavoriteQuoteScreenPreview() {
    QuoteGeneratorTheme {
        HorizontalFavoriteQuoteScreen(
            favoriteQuote = null,
            onGoBack = {},
            onUnfavorite = {},
        )
    }
}