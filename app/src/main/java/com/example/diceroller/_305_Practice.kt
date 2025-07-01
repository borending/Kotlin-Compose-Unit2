package com.example.diceroller

// mission 1
// () 裡面宣告屬性
data class EventOld(
    val title: String,
    val description: String?,
    val daypart: String,
    var durationInMinutes: Int
) /*{
    不用 {}
}*/

// mission 2
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    var durationInMinutes: Int
)

val event1 = Event(
    title = "Wake up",
    description = "Time to get up",
    daypart = Daypart.MORNING,
    durationInMinutes = 0
)
val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
val event3 =
    Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
val event5 = Event(
    title = "Watch latest DevBytes video",
    daypart = Daypart.AFTERNOON,
    durationInMinutes = 10
)
val event6 = Event(
    title = "Check out latest Android Jetpack library",
    daypart = Daypart.EVENING,
    durationInMinutes = 45
)

// mission 3
val eventList = mutableListOf(event1, event2, event3, event4, event5, event6)

// mission 4
// 算長度用size，效能比較好
val shortEventsCount = eventList.filter { it.durationInMinutes < 60 }.count()

// mission 5
fun showByDaypart() {
    val daypartList = listOf(Daypart.MORNING, Daypart.AFTERNOON, Daypart.EVENING)
    for (daypart in daypartList) {
        println("${daypart}: ${eventList.filter { it.daypart == daypart }.size} events")
    }
}

// 解答用group，所以嘗試改用group
fun showByDaypart2() {
    val groupEvents = eventList.groupBy { it.daypart }
    for (group in groupEvents)
        println("${group.key}: ${group.value.size} events")

    /*
    *   解答: 用forEach，把group 解構
    *   groupedEvents.forEach { (daypart, events) ->
    *       println("$daypart: ${events.size} events")
    *   }
    */
}

// mission 6
fun showLast() {
    println("Last event of the day: ${eventList.last().title}")
}

// mission 7 擴充屬性: 解答直接寫if
val Event.durationOfEvent: String
    get() {
        val result = when (this.durationInMinutes) {
            in 0..59 -> "short"
            else -> "long"
        }
        return result
    }

class _305_Practice {
}