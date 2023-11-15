package com.ocomwan.kotlinbasics

const val num = 20

fun main() {
    var i = 10
    var l = 20L

    l = i.toLong()
    i = l.toInt()

    var name = ""
    name = i.toString()

    var name2 = "10"
    i = name2.toInt()
}
