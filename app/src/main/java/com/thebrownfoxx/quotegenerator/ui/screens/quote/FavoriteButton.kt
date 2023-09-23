package com.thebrownfoxx.quotegenerator.ui.screens.quote

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.R
import com.thebrownfoxx.quotegenerator.ui.extension.Elevation
import com.thebrownfoxx.quotegenerator.ui.theme.QuoteGeneratorTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
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

    val contentColor by animateColorAsState(
        if (favorite) MaterialTheme.colorScheme.onTertiary
        else MaterialTheme.colorScheme.onTertiaryContainer
    )

    val iconScale = remember { Animatable(0.75f) }
    val rotation = remember { Animatable(360f) }

    val animationScope = rememberCoroutineScope()
    fun animateIcon() {
        animationScope.launch {
            launch {
                iconScale.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = LinearOutSlowInEasing,
                    )
                )
                iconScale.animateTo(
                    targetValue = 0.75f,
                    animationSpec = tween(
                        delayMillis = 200,
                        durationMillis = 300,
                        easing = FastOutSlowInEasing,
                    )
                )
            }
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
            if (!favorite) animateIcon()
            onClick()
        },
        color = color,
        contentColor = contentColor,
        shape = CircleShape,
        tonalElevation = Elevation.level(1),
        modifier = modifier,
    ) {
        AnimatedContent(
            targetState = favorite,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            }
        ) { favorite ->
            val icon =
                if (favorite) Icons.Filled.Star
                else Icons.Filled.StarOutline

            Icon(
                imageVector = icon,
                contentDescription = stringResource(R.string.star_icon),
                modifier = Modifier
                    .padding(20.dp)
                    .size(32.dp)
                    .scale(iconScale.value)
                    .rotate(rotation.value),
            )
        }
    }
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