package com.thebrownfoxx.quotegenerator.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.twotone.AutoAwesome
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material.icons.twotone.SentimentVerySatisfied
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.logic.QuoteCategory
import com.thebrownfoxx.quotegenerator.ui.components.HugeAssButton
import com.thebrownfoxx.quotegenerator.ui.components.icon
import com.thebrownfoxx.quotegenerator.ui.components.iconContentDescriptionResourceId
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorIcons
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@Composable
fun QuoteCategoryButton(
    category: QuoteCategory,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val text = when (category) {
        QuoteCategory.Love -> stringResource(R.string.love_quotes)
        QuoteCategory.Inspirational -> stringResource(R.string.inspirational_quotes)
        QuoteCategory.Funny -> stringResource(R.string.funny_quotes)
    }

    HugeAssButton(
        icon = category.icon,
        iconContentDescription = stringResource(id = category.iconContentDescriptionResourceId),
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
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(16.dp)
        )
    }
}