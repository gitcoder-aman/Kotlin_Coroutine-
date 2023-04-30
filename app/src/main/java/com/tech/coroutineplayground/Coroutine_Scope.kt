package com.tech.coroutineplayground

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//fun main() = runBlocking{
//
//    println("$this")
//    println("$coroutineContext")
//}

private val scope = CoroutineScope(Dispatchers.Default + CoroutineName("$100"))

fun main() {
    scope.launch(Dispatchers.IO + CoroutineName("C100")) {
//        println("$this")
//        println("$coroutineContext")
//        println("${coroutineContext[CoroutineName.Key]}")
        println("C1 started")
        delay(300)
        println("C1 completed")
    }
    Thread.sleep(100)
    onDestroy()
}
private fun onDestroy() {
    println("Cancelling scope")
    scope.cancel()
}
