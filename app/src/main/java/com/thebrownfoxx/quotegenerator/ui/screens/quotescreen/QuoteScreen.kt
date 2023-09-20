package com.thebrownfoxx.quotegenerator.ui.screens.quotescreen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.logic.Quote
import com.thebrownfoxx.quotegenerator.logic.QuoteCategory
import com.thebrownfoxx.quotegenerator.ui.SampleQuote
import com.thebrownfoxx.quotegenerator.ui.components.icon
import com.thebrownfoxx.quotegenerator.ui.components.iconContentDescriptionResourceId
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme
import com.thebrownfoxx.quotegenerator.ui.transitions.sharedXAxis

@Composable
fun QuoteScreen(
    quote: Quote,
    favorite: Boolean,
    onClose: () -> Unit,
    onRefresh: () -> Unit,
    onFavorite: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current

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
            AnimatedContent(
                targetState = quote,
                transitionSpec = { density.sharedXAxis() },
                modifier = Modifier.weight(1f)
            ) { quote ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxSize(),
                ) {
                    Icon(
                        imageVector = quote.category.icon,
                        contentDescription = stringResource(
                            quote.category.iconContentDescriptionResourceId
                        ),
                    )
                    Text(text = label.uppercase())
                    Text(
                        text = quote.value,
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(),
            ) {
                CloseButton(onClick = onClose)
                RefreshButton(onClick = onRefresh)
                FavoriteButton(favorite = favorite, onClick = onFavorite)
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
        )
    }
}