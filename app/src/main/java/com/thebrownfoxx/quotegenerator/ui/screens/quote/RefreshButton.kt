package com.thebrownfoxx.quotegenerator.ui.screens.quote

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.twotone.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.ui.extension.Elevation
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorIcons
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RefreshButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val rotation = remember { Animatable(360f) }

    val animationScope = rememberCoroutineScope()
    fun animateIcon() {
        animationScope.launch {
            launch {
                rotation.snapTo(rotation.value - 360f)
                rotation.animateTo(
                    targetValue = 360f,
                    animationSpec = tween(
                        durationMillis = 500,
                    )
                )
            }
        }
    }

    Surface(
        onClick = {
            animateIcon()
            onClick()
        },
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = CircleShape,
        tonalElevation = Elevation.level(1),
        modifier = modifier,
    ) {
        Icon(
            imageVector = QuoteGeneratorIcons.Refresh,
            contentDescription = stringResource(R.string.refresh_icon),
            modifier = Modifier
                .padding(32.dp)
                .size(32.dp)
                .rotate(rotation.value),
        )
    }
}

@Preview
@Composable
fun RefreshButtonPreview() {
    QuoteGeneratorTheme {
        RefreshButton(
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}