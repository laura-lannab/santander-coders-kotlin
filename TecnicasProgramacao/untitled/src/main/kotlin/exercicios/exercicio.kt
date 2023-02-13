package exercicios

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun Int.returnaDobrado(): Int {
    return this * 2
}

fun Int.retornaSoma(value:Int): Int{
    return this + value
}

fun String.remove(): String{
    return this.drop(1)
}

fun LocalDate.yesterday(): LocalDate {
    return this.minusDays(1)
}

fun LocalDate.tomorrow(): LocalDate {
    return this.plusDays(1)
}

val LocalDate.format : String
    get() = this.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))


fun <T> MutableList<T>.switch(index1: Int, index2: Int){
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

fun List<String>.maior(){
    var maior = this[0]
    for(item in this){
        if(item.length > maior.length){
            maior = item
        }
    }
    println(maior)
}

fun main() {
//    val word = "*Laura"
//    println(word.remove())
//
//    println(LocalDate.now().yesterday().format)
//    println(LocalDate.now().tomorrow())
//
    var herois = mutableListOf("Batman", "Cyborg", "Flash")
    herois.switch(0,2)
    println(herois)
}