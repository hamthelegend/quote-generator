package com.thebrownfoxx.quotegenerator.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import com.thebrownfoxx.quotegenerator.ui.transitions.sharedXAxis

@Suppress("NAME_SHADOWING")
@Composable
fun Quote(
    quote: String,
    icon: ImageVector,
    iconContentDescription: String?,
    label: String,
) {
    val density = LocalDensity.current

    Icon(
        imageVector = icon,
        contentDescription = iconContentDescription,
    )
    Text(text = label.uppercase())
    AnimatedContent(
        targetState = quote,
        transitionSpec = { density.sharedXAxis() },
    ) { quote ->
        Text(
            text = quote,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}