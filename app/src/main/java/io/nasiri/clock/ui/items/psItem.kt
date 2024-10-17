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
fun PsItem(modifier: Modifier = Modifier, isActive: Boolean = false) {
    Canvas(
        modifier = modifier
            .width(80.dp)
            .height(20.dp)
    ) {

        val color = Color.Blue.copy(alpha = if (isActive) 1f else .3f)
        val path = Path().apply {
            moveTo(size.width, size.height / 2)
            lineTo(size.width - 10.dp.toPx(), 0f)
            lineTo(size.width - 70.dp.toPx(), 0f)
            lineTo(0f, size.height / 2)
        }
        drawPath(path = path, color = color)
        rotate(180f) { drawPath(path = path, color = color) }
    }
}