package com.thebrownfoxx.quotegenerator.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
        AnimatedContent(
            targetState = icon,
            transitionSpec = { density.sharedXAxis() },
            modifier = Modifier.fillMaxWidth(),
        ) { icon ->
            Box {
                Icon(
                    imageVector = icon,
                    contentDescription = iconContentDescription,
                    modifier = Modifier.align(Alignment.CenterStart),
                )
            }
        }
        AnimatedContent(
            targetState = label,
            transitionSpec = { density.sharedXAxis() },
            modifier = Modifier.fillMaxWidth(),
        ) { label ->
            Text(
                text = label.uppercase(),
                fontWeight = FontWeight.SemiBold,
            )
        }
        AnimatedContent(
            targetState = quote to author,
            transitionSpec = { density.sharedXAxis() },
            modifier = Modifier.fillMaxWidth(),
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