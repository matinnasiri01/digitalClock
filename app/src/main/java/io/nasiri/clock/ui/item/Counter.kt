package io.nasiri.clock.ui.item

import androidx.compose.foundation.Canvas
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
    boxHeight: Dp = 190.dp,
    verticalPadding: Dp = 13.dp,
    spacerHeight: Dp = 4.dp,
    itemWidth: Dp = 20.dp,
    itemHeight: Dp = 80.dp,
    vpItemWidth: Dp = 80.dp,
    vpItemHeight: Dp = 20.dp
) {
    Box(
        modifier = modifier.size(width = boxWidth, height = boxHeight)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = verticalPadding),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                HeItem(
                    isActive = active[1],
                    activeColor = showColor,
                    itemWidth = itemWidth,
                    itemHeight = itemHeight
                )
                Spacer(modifier = Modifier.height(spacerHeight))
                HeItem(
                    isActive = active[4],
                    activeColor = showColor,
                    itemWidth = itemWidth,
                    itemHeight = itemHeight
                )
            }
            Column {
                HeItem(
                    isActive = active[2],
                    activeColor = showColor,
                    itemWidth = itemWidth,
                    itemHeight = itemHeight
                )
                Spacer(modifier = Modifier.height(spacerHeight))
                HeItem(
                    isActive = active[5],
                    activeColor = showColor,
                    itemWidth = itemWidth,
                    itemHeight = itemHeight
                )
            }
        }
        VoItem(
            modifier = Modifier.align(Alignment.TopCenter),
            isActive = active[0],
            activeColor = showColor,
            vpItemWidth = vpItemWidth,
            vpItemHeight = vpItemHeight
        )
        VoItem(
            modifier = Modifier.align(Alignment.Center),
            isActive = active[3],
            activeColor = showColor,
            vpItemWidth = vpItemWidth,
            vpItemHeight = vpItemHeight
        )
        VoItem(
            modifier = Modifier.align(Alignment.BottomCenter),
            isActive = active[6],
            activeColor = showColor,
            vpItemWidth = vpItemWidth,
            vpItemHeight = vpItemHeight
        )
    }
}

@Composable
fun HeItem(
    modifier: Modifier = Modifier,
    isActive: Boolean = false,
    activeColor: Color,
    itemWidth: Dp = 20.dp,
    itemHeight: Dp = 80.dp
) {
    Canvas(
        modifier = modifier
            .width(itemWidth)
            .height(itemHeight)
    ) {
        val color = activeColor.copy(alpha = if (isActive) 1f else .1f)
        val path = Path().apply {
            moveTo(size.width / 2, 0f)
            lineTo(0f, 10.dp.toPx())
            lineTo(0f, (itemHeight - 10.dp).toPx())
            lineTo(size.width / 2, size.height)
        }
        drawPath(path = path, color = color)
        rotate(180f) { drawPath(path = path, color = color) }
    }
}

@Composable
fun VoItem(
    modifier: Modifier = Modifier,
    isActive: Boolean = false,
    activeColor: Color,
    vpItemWidth: Dp = 80.dp,
    vpItemHeight: Dp = 20.dp
) {
    Canvas(
        modifier = modifier
            .width(vpItemWidth)
            .height(vpItemHeight)
    ) {
        val color = activeColor.copy(alpha = if (isActive) 1f else .1f)
        val path = Path().apply {
            moveTo(size.width, size.height / 2)
            lineTo(size.width - 10.dp.toPx(), 0f)
            lineTo(size.width - (vpItemWidth - 10.dp).toPx(), 0f)
            lineTo(0f, size.height / 2)
        }
        drawPath(path = path, color = color)
        rotate(180f) { drawPath(path = path, color = color) }
    }
}