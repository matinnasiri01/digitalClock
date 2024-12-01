package io.nasiri.clock.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.nasiri.clock.ui.item.SingleCounter
import io.nasiri.clock.util.TimeData
import io.nasiri.clock.util.new01
import io.nasiri.clock.vertical

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
                    color = Color.Gray.copy(.2f), shape = RoundedCornerShape(30.dp)
                )
                .padding(horizontal = 40.dp, vertical = 30.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Box(
                    modifier = Modifier.size(100.dp, 180.dp),
                ) {

                    SingleCounter(
                        showColor = Color.Black,
                        active = new01[data.hours.first]?.map { it == 1 }!!,
                        boxWidth = 40.dp
                    )
                    SingleCounter(
                        showColor = Color.Black,
                        modifier = Modifier.align(Alignment.TopEnd),
                        active = new01[data.hours.second]?.map { it == 1 }!!,
                        boxWidth = 40.dp
                    )
                    SingleCounter(
                        showColor = Color.Black,
                        modifier = Modifier.align(Alignment.BottomEnd),
                        active = new01[data.minutes.second]?.map { it == 1 }!!,
                        boxWidth = 40.dp
                    )

                    SingleCounter(
                        showColor = Color.Black,
                        modifier = Modifier.align(Alignment.BottomStart),
                        active = new01[data.minutes.first]?.map { it == 1 }!!,
                        boxWidth = 40.dp
                    )
                }
                Row(
                    modifier = Modifier
                        .graphicsLayer(rotationZ = 270f)
                        .vertical(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val annotatedString = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold, fontSize = 20.sp
                            )
                        ) {
                            append("${data.day}, ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Light, fontSize = 20.sp
                            )
                        ) {
                            append(data.month.uppercase())
                        }
                    }
                    Text(text = annotatedString)
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = data.dayName.uppercase(),
                        color = Color.Red,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .background(
                                color = Color.White, shape = RoundedCornerShape(10.dp)
                            )
                            .padding(horizontal = 4.dp)
                    )
                }
            }
        }
    }
}