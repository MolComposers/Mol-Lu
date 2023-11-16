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
}
