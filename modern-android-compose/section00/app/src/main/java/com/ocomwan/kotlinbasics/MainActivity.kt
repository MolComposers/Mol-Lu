package com.ocomwan.kotlinbasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        practiceSuspendFunctionAndCoroutine(10) -> coroutine scope 내부에서 호출해야함
        lifecycleScope.launch {
            practiceSuspendFunctionAndCoroutine(100) {
                // 콜백 함수 내용
            }
        }
    }
}

// suspend function : 정지 함수로 끝날 때까지 대기. 메인 스레드에서 실행 불가능
//     - suspend 함수 내부 실행
//     - coroutine scope 내부 실행
suspend fun practiceSuspendFunctionAndCoroutine(a: Int, callback: () -> Unit = { }) {
    println("함수 시작!")
    callback()
    println("함수 끝!")
}
