package com.example.diceroller

// enum: 列舉類別
enum class Difficulty(val value: Int) {
    EASY(1),
    MEDIUM(4),
    HARD(10)
}

// 泛型
// data-class: 資料類別，適合當作資料結構載體，進行操作:複製/比較 等等
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

// object 靜態, 唯一的物件
object Student {
    var name: String = "Tom"
    var classNumber: Int = 1
}

// 介面
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

// 一般class 適合實作業務邏輯
class Quiz: ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    // companion 可以將靜態物件歸類在class 之下，但又保持唯一性
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    // 實作介面屬性: +override
    override val progressText: String
        get() = "$answered of $total ansered"

    // 實作介面方法: +override
    override fun printProgressBar(){
        repeat(answered) { print("▓") }
        repeat(total - answered) { print("▒") }
        println()
        println(progressText)
    }

    fun printQuiz() {
        println(question1.questionText)
        println(question1.answer)
        println(question1.difficulty)
        println()

        // 範圍函式: 簡化變數存取
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
            println()
        }

        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
            println()
        }
    }
}

/*
// 擴充屬性 寫法
val Quiz.StudentProgress.progressText: String
	get() = "${answered} of ${total} answered"
*/

/*
// 擴充方法 寫法
fun Quiz.StudentProgress.printProgressBar(){
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
	println()
    println(Quiz.progressText)
}
*/

fun main() {
    /*val quiz = Quiz()
    quiz.printQuiz()*/

    // apply: 可以在初始化的時候，呼叫物件的函數以簡化程式
    val quiz = Quiz().apply {
        printQuiz()
        println()
        printProgressBar()
    }
}