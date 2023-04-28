package com.tech.coroutineplayground

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

//fun main() {
//  Normal task in method/function/routine
//    routineOne()
//    routineTwo()
//}
fun main() = runBlocking {

    println("Main Starts")

    println("Normal task in method")
    routineOne()
    routineTwo()
    println("Normal task method are completed")

    println("Start Coroutine Task is Started")
    joinAll(
        async { coroutineOne() },
        async { coroutineTwo() }
    )
    println("Start Coroutine Task is Started")
    println("Main Ends")
}
fun routineOne() {
    println("Routine One is Started.")
    Thread.sleep(3000)
    println("Routine One is Completed")
}
fun routineTwo() {
    println("Routine Two is Started.")
    Thread.sleep(2000)
    println("Routine Two is Completed")
}
suspend fun coroutineOne() {
    println("CoRoutine One is Started.")
    delay(3000)
    println("CoRoutine One is Completed")
}
suspend fun coroutineTwo() {
    println("CoRoutine Two is Started.")
    delay(4000)
    println("CoRoutine Two is Completed")
}
