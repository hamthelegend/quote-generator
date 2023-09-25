package com.thebrownfoxx.quotegenerator.ui.screens.quote

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.logic.QuoteCategory
import com.thebrownfoxx.quotegenerator.ui.components.icon
import com.thebrownfoxx.quotegenerator.ui.components.iconContentDescription
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteCategoryChip(
    category: QuoteCategory,
    onClick: () -> Unit,
    selected: Boolean,
    modifier: Modifier = Modifier,
) {
    val color by animateColorAsState(
        if (selected) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.secondaryContainer
    )
    val contentColor by animateColorAsState(
        if (selected) MaterialTheme.colorScheme.onSecondary
        else MaterialTheme.colorScheme.onSecondaryContainer
    )

    Surface(
        modifier = modifier,
        color = color,
        contentColor = contentColor,
        shape = CircleShape,
        onClick = onClick,
    ) {
        Icon(
            imageVector = category.icon,
            contentDescription = category.iconContentDescription,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun QuoteCategoryChipPreview() {
    QuoteGeneratorTheme {
        QuoteCategoryChip(
            category = QuoteCategory.Love,
            onClick = {},
            selected = true,
            modifier = Modifier.padding(16.dp),
        )
    }
}