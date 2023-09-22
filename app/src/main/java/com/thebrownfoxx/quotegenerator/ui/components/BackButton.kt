package com.thebrownfoxx.quotegenerator.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorIcons
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme

@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    FilledIconButton(
        icon = QuoteGeneratorIcons.ArrowBack,
        contentDescription = stringResource(R.string.back_icon),
        onClick = onClick,
        modifier = modifier,
    )
}

@Preview
@Composable
fun BackButtonPreview() {
    QuoteGeneratorTheme {
        BackButton(
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}