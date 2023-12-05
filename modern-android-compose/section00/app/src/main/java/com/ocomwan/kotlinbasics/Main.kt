package com.ocomwan.kotlinbasics

import java.util.Scanner
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

const val num = 20 // Compile Time Constant

fun main() {
    practiceNullSafety()
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
    // num = 30 (X)
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

private fun practiceLoop() {
    val items = listOf(1, 2, 3, 4, 5)

    for (item in items) {
        print(item)
    }

    items.forEach { item ->
        print(item)
    }

    // for (int i = 0; i < items.length; i++)
    for (i in 0..(items.size - 1)) {
        print(items[i])
    }

    for (i in 0 until items.size) {
        print(items[i])

        break
        continue
    }
}

private fun practiceList() {
    val items = listOf(1, 2, 3, 4, 5)

//    items.add()

    val mutableItems = mutableListOf(1, 2, 3, 4, 5)
    mutableItems.add(6)
    mutableItems.remove(3)
}

private fun practiceArray() {
    val items = arrayOf(1, 2, 3)
    items.size
    items.get(0)
    items.set(0, 10) // Java
    items[0] = 10 // Kotlin

    // List를 활용하는 것이 권장됨

    try {
        val item = items[4]
    } catch (e: Exception) {
        print(e.message)
    }
}

private fun practiceNullSafety() {
    var name: String? = null
    name = "채연"
    name = null

    var name2: String = ""
    if (name != null) {
        name2 = name
    }

    name2 = name!!

    name?.let {
        name2 = name
    }
}
