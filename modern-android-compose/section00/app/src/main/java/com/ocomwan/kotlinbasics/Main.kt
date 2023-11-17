package com.ocomwan.kotlinbasics

import java.util.Scanner
import kotlin.random.Random

fun main() {
    // Random
    var randomNumber = Random.nextInt()
    print(randomNumber)

    randomNumber = Random.nextInt(0, 100) // 0 ~ 99
    print(randomNumber)

    val randomDouble = Random.nextDouble(0.0, 1.0) // 0.0 ~ 0.9999...
    print(randomDouble)

    // 키보드 입력
    val reader = Scanner(System.`in`)

    val numberInput = reader.nextInt()
    println(numberInput)
    val stringInput = reader.next()
    println(stringInput)

    // 조건문
    val i = 5
    if (i > 10) {
        print("10보다 크다")
    } else if (i > 5) {
        print("5보다 크다")
    } else {
        print("")
    }

    val result = when {
        i > 10 -> "10보다 크다"
        i > 5 -> "5보다 크다"
        else -> "!!!"
    }
    println(result)
}
