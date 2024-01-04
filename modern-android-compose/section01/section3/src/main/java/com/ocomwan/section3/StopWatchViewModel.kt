package com.ocomwan.section3

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ocomwan.section3.StopWatchState.Running
import com.ocomwan.section3.StopWatchState.Stop
import java.util.Timer
import kotlin.concurrent.timer

class StopWatchViewModel : ViewModel() {
    private val _stopWatchState: MutableState<StopWatchState> = mutableStateOf(Stop)
    val stopWatchState: State<StopWatchState>
        get() = _stopWatchState

    private val _sec = mutableStateOf(0)
    val sec: State<Int>
        get() = _sec

    private val _milliSec = mutableStateOf(0)
    val milliSec: State<Int>
        get() = _milliSec

    private val _lapTimes = mutableStateOf(mutableListOf<String>())
    val lapTimes: State<List<String>> get() = _lapTimes

    private var time = 0
    private var timerTask: Timer? = null
    private var lap = 0

    private fun start() {
        _stopWatchState.value = Running
        timerTask = timer(period = 10) {
            time++
            _sec.value = time / 100
            _milliSec.value = time % 100
        }
    }

    private fun pause() {
        _stopWatchState.value = Stop
        timerTask?.cancel()
    }

    private fun reset() {
        timerTask?.cancel()
        time = 0
        _stopWatchState.value = Stop
        _sec.value = 0
        _milliSec.value = 0

        _lapTimes.value.clear()
        lap = 1
    }

    private fun recordLapTime() {
        _lapTimes.value.add(0, "$lap LAP : ${sec.value}.${milliSec.value}")
        lap++
    }
}
