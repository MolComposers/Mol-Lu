package com.ocomwan.section3

sealed class StopWatchState {
    object Running : StopWatchState()
    object Stop : StopWatchState()
}
