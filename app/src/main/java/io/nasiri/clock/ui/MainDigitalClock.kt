package io.nasiri.clock.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.nasiri.clock.ui.item.SingleCounter
import io.nasiri.clock.util.new01
import io.nasiri.clock.vertical

@Composable
fun MainDigitalClock(modifier: Modifier = Modifier, data: List<String>) {
    val ss = data[0].split("").filter { it.isNotBlank() }.map { it.toInt() }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 40.dp), contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .background(
                    color = Color.Gray.copy(.2f), shape = RoundedCornerShape(30.dp)
                )
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.height(360.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(180.dp)
                ) {

                    SingleCounter(
                        showColor = Color.Black,
                        active = new01[ss[0]]?.map { it == 1 }!!,
                        boxWidth = 80.dp
                    )
                    SingleCounter(
                        showColor = Color.Black,
                        modifier = Modifier.align(Alignment.TopEnd),
                        active = new01[ss[1]]?.map { it == 1 }!!,
                        boxWidth = 80.dp
                    )
                    SingleCounter(
                        showColor = Color.Black,
                        modifier = Modifier.align(Alignment.BottomEnd),
                        active = new01[ss[3]]?.map { it == 1 }!!,
                        boxWidth = 80.dp
                    )

                    SingleCounter(
                        showColor = Color.Black,
                        modifier = Modifier.align(Alignment.BottomStart),
                        active = new01[ss[2]]?.map { it == 1 }!!,
                        boxWidth = 80.dp
                    )
                }
                Row(
                    modifier = Modifier
                        .rotate(270f)
                        .vertical()
                ) {
                    val annotatedString = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("${data[1]}, ")
                        }
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Light)) {
                            append("${data[2]} ")
                        }
                    }
                    Text(text = annotatedString)
                    Text(
                        text = data[3],
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .background(
                                color = Color.White, shape = RoundedCornerShape(10.dp)
                            )
                            .padding(vertical = 2.dp, horizontal = 4.dp)
                    )
                }
            }
        }
    }
}