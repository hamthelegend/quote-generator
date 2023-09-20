package com.thebrownfoxx.quotegenerator.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.ui.extension.Elevation
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorIcons
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilledIconButton(
    icon: ImageVector,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.secondaryContainer,
) {
    Surface(
        onClick = onClick,
        color = color,
        shape = CircleShape,
        tonalElevation = Elevation.level(1),
        modifier = modifier,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.padding(24.dp),
        )
    }
}

@Preview
@Composable
fun CircledIconPreview() {
    QuoteGeneratorTheme {
        FilledIconButton(
            icon = QuoteGeneratorIcons.Favorite,
            contentDescription = "Favorite",
            onClick = {},
            modifier = Modifier.padding(16.dp),
        )
    }
}