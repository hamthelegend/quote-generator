package com.thebrownfoxx.quotegenerator.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.thebrownfoxx.quotegenerator.ui.extension.Elevation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HugeAssButton(
    icon: ImageVector,
    iconContentDescription: String?,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(backgroundColor = color),
    enabled: Boolean = true,
) {
    val animatedColor by animateColorAsState(
        if (enabled) color
        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
    )
    val animatedContentColor by animateColorAsState(
        if (enabled) contentColor
        else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
    )

    Surface(
        onClick = onClick,
        shape = CircleShape,
        color = animatedColor,
        contentColor = animatedContentColor,
        tonalElevation = Elevation.level(2),
        modifier = modifier,
        enabled = enabled,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(24.dp),
        ) {
            Icon(
                imageVector = icon,
                contentDescription = iconContentDescription,
            )
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}