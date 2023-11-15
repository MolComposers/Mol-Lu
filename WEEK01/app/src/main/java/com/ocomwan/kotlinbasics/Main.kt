package com.ocomwan.kotlinbasics

const val num = 20

fun main() {
    var name = "hello"
    print(name.uppercase())
    print(name.lowercase())
    print(name[0])

    name = "채연"
    print("제 이름은 ${name}입니다.")
    print("제 이름은 ${name + 10}입니다.")
}
