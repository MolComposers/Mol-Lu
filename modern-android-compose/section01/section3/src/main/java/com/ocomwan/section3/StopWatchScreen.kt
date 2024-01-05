@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class,
)

package com.ocomwan.section3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ocomwan.section3.StopWatchState.Pause
import com.ocomwan.section3.StopWatchState.Running
import com.ocomwan.section3.ui.theme.MyApplicationTheme

class StopWatchScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<StopWatchViewModel>()
            val sec = viewModel.sec.value
            val milliSec = viewModel.milliSec.value
            val stopWatchState = viewModel.stopWatchState.value
            val lapTimes = viewModel.lapTimes.value

            MyApplicationTheme {
                MainScreen(
                    sec = sec,
                    milliSec = milliSec,
                    stopWatchState = stopWatchState,
                    lapTimes = lapTimes,
                    onReset = { viewModel.reset() },
                    onToggle = { state ->
                        when (state) {
                            Pause -> {
                                viewModel.start()
                            }

                            Running -> {
                                viewModel.pause()
                            }
                        }
                    },
                    onLapTime = { viewModel.recordLapTime() },
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    sec: Int,
    milliSec: Int,
    stopWatchState: StopWatchState,
    lapTimes: List<String>,
    onReset: () -> Unit,
    onToggle: (StopWatchState) -> Unit,
    onLapTime: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.section3_stop_watch)) })
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Row(
                verticalAlignment = Alignment.Bottom,
            ) {
                Text(
                    text = "$sec",
                    fontSize = 100.sp,
                )
                Text(
                    text = "$milliSec".padStart(2, '0'),
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
            ) {
                lapTimes.forEach { lapTime ->
                    Text(lapTime) // TODO : 문자열은 액티비티에서 넣어주기
                }
            }

            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier.weight(1f),
                ) {
                    FloatingActionButton(
                        onClick = { onReset() },
                        containerColor = Color.Red,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_refresh_24),
                            contentDescription = stringResource(R.string.section3_refresh_button),
                            colorFilter = ColorFilter.tint(color = Color.White),
                        )
                    }
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.weight(1f),
                ) {
                    FloatingActionButton(
                        onClick = { onToggle(stopWatchState) },
                        containerColor = Color.Green,
                    ) {
                        Image(
                            painter = painterResource(
                                id = when (stopWatchState) {
                                    Pause -> R.drawable.baseline_play_arrow_24
                                    Running -> R.drawable.baseline_pause_24
                                },
                            ),
                            contentDescription = stringResource(R.string.section3_toggle_button),
                            colorFilter = ColorFilter.tint(color = Color.White),
                        )
                    }
                }

                Box(
                    contentAlignment = Alignment.CenterEnd,
                    modifier = Modifier.weight(1f),
                ) {
                    Button(
                        onClick = { onLapTime() },
                    ) {
                        Text(stringResource(R.string.section3_lap_time))
                    }
                }
            }
        }
    }
}
