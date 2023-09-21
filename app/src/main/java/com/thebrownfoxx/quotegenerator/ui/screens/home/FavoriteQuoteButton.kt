package com.thebrownfoxx.quotegenerator.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.ui.components.HugeAssButton
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorIcons
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@Composable
fun FavoriteQuoteButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    HugeAssButton(
        icon = QuoteGeneratorIcons.Star,
        iconContentDescription = stringResource(R.string.star_icon),
        text = stringResource(R.string.favorite_quote),
        color = MaterialTheme.colorScheme.tertiaryContainer,
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
    )
}

@Preview
@Composable
fun FavoriteQuoteButtonPreview() {
    QuoteGeneratorTheme {
        FavoriteQuoteButton(onClick = {}, modifier = Modifier.padding(16.dp))
    }
}