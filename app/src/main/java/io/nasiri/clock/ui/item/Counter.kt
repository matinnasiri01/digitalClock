package io.nasiri.clock.ui.item

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SingleCounter(
    modifier: Modifier = Modifier,
    active: List<Boolean>,
    showColor: Color = Color.Blue,
    boxWidth: Dp = 100.dp,
) {

    require(active.size == 7) { "The 'active' list must have exactly 7 elements." }

    val boxHeight = boxWidth * 2
    val spacerHeight = boxHeight * .02f
    val sSize = boxWidth * .2f
    val bSize = boxWidth * .8f
    val bHSize = boxWidth * .86f
    val pointerSize = bSize * .125f

    Box(modifier = modifier.size(width = boxWidth, height = boxHeight)) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(spacerHeight)) {
                SiItem(
                    isActive = active[1],
                    activeColor = showColor,
                    width = sSize,
                    height = bHSize,
                    pointerSize = pointerSize
                )
                SiItem(
                    isActive = active[4],
                    activeColor = showColor,
                    width = sSize,
                    height = bHSize,
                    pointerSize = pointerSize
                )
            }
            Column(verticalArrangement = Arrangement.spacedBy(spacerHeight)) {
                SiItem(
                    isActive = active[2],
                    activeColor = showColor,
                    width = sSize,
                    height = bHSize,
                    pointerSize = pointerSize
                )
                SiItem(
                    isActive = active[5],
                    activeColor = showColor,
                    width = sSize,
                    height = bHSize,
                    pointerSize = pointerSize
                )
            }
        }
        SiItem(
            modifier = Modifier.align(Alignment.TopCenter),
            isActive = active[0],
            activeColor = showColor,
            width = bSize,
            height = sSize,
            pointerSize = pointerSize
        )
        SiItem(
            modifier = Modifier.align(Alignment.Center),
            isActive = active[3],
            activeColor = showColor,
            width = bSize,
            height = sSize,
            pointerSize = pointerSize
        )
        SiItem(
            modifier = Modifier.align(Alignment.BottomCenter),
            isActive = active[6],
            activeColor = showColor,
            width = bSize,
            height = sSize,
            pointerSize = pointerSize
        )
    }
}

@Composable
fun SiItem(
    modifier: Modifier = Modifier,
    isActive: Boolean = false,
    activeColor: Color,
    width: Dp,
    height: Dp,
    pointerSize: Dp
) {
    Canvas(modifier = modifier.size(width, height)) {

        val color = activeColor.copy(alpha = if (isActive) 1f else .1f)

        var path = createHorizontalPath(width.toPx(), height.toPx(), pointerSize.toPx())
        if (width > height) path =
            createVerticalPath(width.toPx(), height.toPx(), pointerSize.toPx())

        drawPath(path = path, color = color)
        rotate(180f) { drawPath(path = path, color = color) }
    }
}

fun createVerticalPath(w: Float, h: Float, ps: Float): Path = Path().apply {
    moveTo(0f, h / 2)
    lineTo(ps, 0f)
    lineTo(w - ps, 0f)
    lineTo(w, h / 2)
}

fun createHorizontalPath(w: Float, h: Float, ps: Float): Path = Path().apply {
    moveTo(w / 2, 0f)
    lineTo(0f, ps)
    lineTo(0f, h - ps)
    lineTo(w / 2, h)
}