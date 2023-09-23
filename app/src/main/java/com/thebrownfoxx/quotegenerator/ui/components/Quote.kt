package com.thebrownfoxx.quotegenerator.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.ui.transitions.sharedXAxis

@Composable
fun Quote(
    quote: String,
    icon: ImageVector,
    iconContentDescription: String?,
    label: String,
    modifier: Modifier = Modifier,
    author: String? = null,
) {
    val density = LocalDensity.current

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
        modifier = modifier,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconContentDescription,
        )
        Text(
            text = label.uppercase(),
            fontWeight = FontWeight.SemiBold,
        )
        AnimatedContent(
            targetState = quote to author,
            transitionSpec = { density.sharedXAxis() },
        ) { (quote, author) ->
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
            ) {
                Text(
                    text = quote,
                    style = MaterialTheme.typography.titleLarge,
                )
                if (author != null) {
                    Text(text = author)
                }
            }
        }
    }
}