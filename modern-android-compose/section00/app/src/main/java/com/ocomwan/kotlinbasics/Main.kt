package com.ocomwan.kotlinbasics

import java.util.Scanner
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

const val num = 20 // Compile Time Constant

fun main() {
    practiceCallbackFunction()
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

private fun practiceFunction() {
    // Method와 Function의 차이점
    print(sum(10, 20))
    print(sum(b = 20, a = 30)) // 순서를 바꿔도 괜찮음. 명시적. 가독성 향상.
}

// Top-Level Function : 모든 파일에서 사용 가능
fun sum(a: Int, b: Int, c: Int = 0): Int {
    return a + b + c
}

fun sum2(a: Int, b: Int, c: Int = 0) = a + b + c

// Java Method Overload
// fun sum(a: Int, b: Int) = a + b
// fun sum(a: Int, b: Int, c: Int) = a + b + c

private fun practiceClassDataClassGetterSetter() {
    val john = Person("John", 20)
    val john2 = Person("John", 20)
//    print(john.name)
    print(john.age)

//    john.name = "Bell"
    john.age = 24

    println(john)
    println(john2)
    println(john == john2) // false
    println(john === john2)
//    john.hobby = "탁구"
}

// data class : equals, hashCode 등의 함수 자동 재정의
data class Person(
    private val name: String, // getter 미제공
    var age: Int,
) {
    var hobby = "축구"
        private set // setter 미제공
        get() = "취미 : $field"

    // 생성할 때마다 실행
    init {
        print("init")
    }

    fun some() {
        hobby = "농구"
    }
}

private fun practiceExtends() {
    val dog = Dog()
    val cat = Cat()

    println(dog.move())
    println(cat.move())
}

abstract class Animal {
    // 코틀린은 open 키워드를 붙여야 override 가능
    open fun move() {
        println("이동!")
    }
}

class Dog : Animal(), Drawable {
    override fun move() {
        println("껑충? 강아지가 왜 껑충 뜀")
    }

    override fun draw() {
        println("강아지 그리기")
    }
}

class Cat : Animal(), Drawable {
    override fun move() {
        println("고양이는 살금 ㅇㅈ")
    }

    override fun draw() {
        println("고양이 그리기")
    }
}

// 기본 클래스는 상속 불가능, open 키워드 필요
open class Human

class SuperMan : Human()

private fun practiceInterface() {
    val dog = Dog()
    val cat = Cat()

    println(dog.draw())
    println(cat.draw())
}

interface Drawable {
    fun draw()
}

private fun practiceTypeCheckIs() {
    val dog: Animal = Dog()
    val cat = Cat()

    dog.move()
//    dog.draw() -> Animal 타입 상태에서는 사용 불가능

    if (dog is Dog) { // true
        println("멍멍이")
        dog.move()
        dog.draw() // Dog로 타입 변환된 후에는 사용 가능
    }
//    if (dog is Cat) println("고양이") -> incompatible type check

    dog as Cat // as : 타입 강제 변환
}

private fun practiceGeneric() {
    val box = Box(10)
    val box2 = Box("박스")

    println(box.value)
    println(box2.value)
}

class Box<T>(var value: T)
// class Box<T>(value: T) -> val 또는 var 지정하지 않으면 getter, setter가 제공되지 않아서 value 호출 불가능 (그냥 인자)

// 콜백 함수 타입 : input과 output 정의:
private fun practiceCallbackFunction() {
    myFunc(10) {
        println("콜백 함수 호출")
    } // 별다른 매개변수가 없다면 소괄호 생략 가능

    myFunc(20)
}

fun myFunc(a: Int, callback: () -> Unit = { /* default */ }) { // input과 output이 없는 함수
    println("함수 시작!")
    callback
    println("함수 끝!")
}
