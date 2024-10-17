package io.nasiri.clock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.nasiri.clock.ui.items.HPsItem
import io.nasiri.clock.ui.items.PsItem

@Composable
fun Single(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 100.dp, height = 190.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 13.dp), Arrangement.SpaceBetween
        ) {
            Column {
                HPsItem(isActive = true)
                Spacer(modifier = Modifier.height(4.dp))
                HPsItem(isActive = true)
            }
            Column {
                HPsItem()
                Spacer(modifier = Modifier.height(4.dp))
                HPsItem(isActive = true)
            }
        }
        PsItem(modifier = Modifier.align(Alignment.TopCenter),isActive = true)
        PsItem(modifier = Modifier.align(Alignment.Center),isActive = true)
        PsItem(modifier = Modifier.align(Alignment.BottomCenter),isActive = true)
    }
}