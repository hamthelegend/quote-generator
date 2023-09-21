package com.thebrownfoxx.quotegenerator.ui.screens.quote

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.ui.components.FilledIconButton
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorIcons
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@Composable
fun FavoriteButton(
    favorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val color by animateColorAsState(
        if (favorite) MaterialTheme.colorScheme.tertiary
        else MaterialTheme.colorScheme.tertiaryContainer
    )

    FilledIconButton(
        icon = QuoteGeneratorIcons.Star,
        contentDescription = stringResource(R.string.star_icon),
        onClick = onClick,
        color = color,
        modifier = modifier,
    )
}

@Preview
@Composable
fun FavoriteButtonPreview() {
    QuoteGeneratorTheme {
        FavoriteButton(
            favorite = false,
            onClick = {},
            modifier = Modifier.padding(16.dp),
        )
    }
}

@Preview
@Composable
fun FavoriteFavoriteButtonPreview() {
    QuoteGeneratorTheme {
        FavoriteButton(
            favorite = true,
            onClick = {},
            modifier = Modifier.padding(16.dp),
        )
    }
}