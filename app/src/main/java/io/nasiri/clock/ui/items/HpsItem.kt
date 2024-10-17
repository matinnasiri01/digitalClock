package io.nasiri.clock.ui.items

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp

@Composable
fun HPsItem(modifier: Modifier = Modifier, isActive: Boolean = false) {
    Canvas(
        modifier = modifier
            .width(20.dp)
            .height(80.dp)
    ) {
        val color = Color.Blue.copy(alpha = if (isActive) 1f else .3f)
        val path = Path().apply {
            moveTo(size.width / 2, 0f)
            lineTo(0f, 10.dp.toPx())
            lineTo(0f, 70.dp.toPx())
            lineTo(size.width / 2, size.height)
        }
        drawPath(path = path, color = color)
        rotate(180f) { drawPath(path = path, color = color) }
    }
}