package com.thebrownfoxx.quotegenerator.ui.screens.favorite

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.ui.extension.Elevation
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorIcons
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnfavoriteButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        onClick = onClick,
        color = MaterialTheme.colorScheme.tertiary,
        shape = CircleShape,
        tonalElevation = Elevation.level(1),
        modifier = modifier,
    ) {
        Icon(
            imageVector = QuoteGeneratorIcons.Star,
            contentDescription = stringResource(R.string.refresh_icon),
            modifier = Modifier
                .padding(32.dp)
                .size(32.dp),
        )
    }
}

@Preview
@Composable
fun FavoriteButtonPreview() {
    QuoteGeneratorTheme {
        UnfavoriteButton(
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}