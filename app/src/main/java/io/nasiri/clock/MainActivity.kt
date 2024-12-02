package io.nasiri.clock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import io.nasiri.clock.ui.MainDigitalClock
import io.nasiri.clock.ui.theme.ClockTheme
import io.nasiri.clock.util.getCurrentTimeData
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClockTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var currentTime by remember { mutableStateOf(getCurrentTimeData()) }

                    LaunchedEffect(Unit) {
                        while (true) {
                            currentTime = getCurrentTimeData()
                            delay(100)
                        }
                    }

                    MainDigitalClock(
                        modifier = Modifier.padding(innerPadding), data = currentTime
                    )
                }
            }
        }
    }
}
