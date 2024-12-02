package io.nasiri.clock.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.nasiri.clock.ui.item.SingleCounter
import io.nasiri.clock.ui.theme.Bglvory
import io.nasiri.clock.ui.theme.Frlvory
import io.nasiri.clock.util.getDigits
import io.nasiri.clock.util.vertical

@Composable
fun MainDigitalClock(modifier: Modifier = Modifier, data: TimeData) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 40.dp), contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Bglvory, shape = RoundedCornerShape(30.dp)
                )
                .padding(horizontal = 40.dp, vertical = 30.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                // Counter section
                CounterSection(data, Frlvory, 40.dp)

                // Date and Day section
                DateAndDaySection(data)
            }
        }
    }
}

@Composable
fun CounterSection(data: TimeData, counterColor: Color, counterWidth: Dp) {
    Box(modifier = Modifier.size(100.dp, 180.dp)) {
        SingleCounter(
            showColor = counterColor, active = data.hours.first.getDigits(), boxWidth = counterWidth
        )
        SingleCounter(
            showColor = counterColor,
            modifier = Modifier.align(Alignment.TopEnd),
            active = data.hours.second.getDigits(),
            boxWidth = counterWidth
        )
        SingleCounter(
            showColor = counterColor,
            modifier = Modifier.align(Alignment.BottomEnd),
            active = data.minutes.second.getDigits(),
            boxWidth = counterWidth
        )
        SingleCounter(
            showColor = counterColor,
            modifier = Modifier.align(Alignment.BottomStart),
            active = data.minutes.first.getDigits(),
            boxWidth = counterWidth
        )
    }
}

@Composable
fun DateAndDaySection(data: TimeData) {
    Row(
        modifier = Modifier
            .graphicsLayer(rotationZ = 270f)
            .vertical(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        val annotatedString = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)) {
                append("${data.day}, ")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Light, fontSize = 20.sp)) {
                append(data.monthName.uppercase())
            }
        }

        Text(text = annotatedString, color = Frlvory)
        Text(
            text = data.dayName.uppercase(),
            color = Color.White,
            fontSize = 10.sp,
            modifier = Modifier
                .background(
                    color = Frlvory, shape = RoundedCornerShape(10.dp)
                )
                .padding(horizontal = 4.dp)
        )
    }
}
