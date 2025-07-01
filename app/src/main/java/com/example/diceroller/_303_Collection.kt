package com.example.diceroller

class _303_Collection {

    // array
    val classAStudents = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
    val classBStudents = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
    val wholeSchoolStudents = classAStudents + classBStudents

    // list: read-only
    val solarSystem =
        listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    // mutableList: C.R.U.D. OK，add, remove, contains....
    val solarSystem2 =
        mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    // Set 和 MutableSet: 沒有順序，所以沒有index。
    // Set 裡面元素不能重複，用class.hashCode 當key
    // 操作方式跟list 相同

    // Map: key-value pairs
    val solarSystem3 = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    // 集合可以用的function
    // forEach()、map()、filter()、groupBy()、fold() 以及 sortedBy()
    // map: 對集合做一些操作，產生一個新集合
    // fold: 對集合做一些操作，產生一個單一值
}