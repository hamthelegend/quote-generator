package com.thebrownfoxx.quotegenerator.ui.screens.quotescreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.twotone.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.ui.components.FilledIconButton
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorIcons
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@Composable
fun CloseButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    FilledIconButton(
        icon = QuoteGeneratorIcons.Close,
        contentDescription = "Close icon",
        onClick = onClick,
        modifier = modifier,
    )
}

@Preview
@Composable
fun CloseButtonPreview() {
    QuoteGeneratorTheme {
        CloseButton(
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}