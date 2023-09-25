package com.thebrownfoxx.quotegenerator.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.logic.QuoteCategory
import com.thebrownfoxx.quotegenerator.ui.components.HugeAssButton
import com.thebrownfoxx.quotegenerator.ui.components.icon
import com.thebrownfoxx.quotegenerator.ui.components.iconContentDescription
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@Composable
fun QuoteCategoryButton(
    category: QuoteCategory,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val text = stringResource(
        when (category) {
            QuoteCategory.Love -> R.string.love_quotes
            QuoteCategory.Inspirational -> R.string.inspirational_quotes
            QuoteCategory.Funny -> R.string.funny_quotes
        }
    )

    HugeAssButton(
        icon = category.icon,
        iconContentDescription = category.iconContentDescription,
        text = text,
        onClick = onClick,
        modifier = modifier,
    )
}

@Preview
@Composable
fun QuoteCategoryButtonPreview() {
    QuoteGeneratorTheme {
        QuoteCategoryButton(
            category = QuoteCategory.Love,
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}