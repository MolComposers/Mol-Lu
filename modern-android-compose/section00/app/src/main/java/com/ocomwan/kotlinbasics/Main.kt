package com.ocomwan.kotlinbasics

import java.util.Scanner
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

const val num = 20 // Compile Time Constant

fun main() {
}

private fun practicePrint() {
    println("Hello World")
    print("Hello World")
}

private fun practiceVariablesAndConstants() {
    var i = 10
    var name = "채연"
    var point = 3.3

    i = 20

    val num = 20
    // num = 30
}

private fun practiceTypeConversion() {
    var i = 10
    var l = 20L

    l = i.toLong()
    i = l.toInt()

    var name = ""
    name = i.toString()

    val name2 = "10"
    i = name2.toInt()
}

private fun practiceString() {
    var name = "hello"
    print(name.uppercase())
    print(name.lowercase())
    print(name[0])

    name = "채연"
    print("제 이름은 ${name}입니다.")
    print("제 이름은 ${name + 10}입니다.")
}

private fun practiceMaxAndMin() {
    val i = 10
    val j = 20

    print(max(i, j))
    print(min(i, j))
}

private fun practiceRandom() {
    var randomNumber = Random.nextInt()
    print(randomNumber)

    randomNumber = Random.nextInt(0, 100) // 0 ~ 99
    print(randomNumber)

    val randomDouble = Random.nextDouble(0.0, 1.0) // 0.0 ~ 0.9999...
    print(randomDouble)
}

private fun practiceKeyboardInput() {
    val reader = Scanner(System.`in`)

    val numberInput = reader.nextInt()
    println(numberInput)
    val stringInput = reader.next()
    println(stringInput)
}

private fun practiceConditionalExpression() {
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

    val booleanResult = if (i > 10) true else false
    println(booleanResult)
}
