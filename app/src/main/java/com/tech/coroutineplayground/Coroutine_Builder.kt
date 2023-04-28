package com.tech.coroutineplayground

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
//fun main() {
//
//    println("Main Start")
//
//    val job = GlobalScope.launch(start=CoroutineStart.LAZY) {
//        val result = doNetworkRequest()
//        println(result)
//    }
//    job.start() // when i'm passing parameter start=CoroutineStart.LAZY then job.start() call for run method
//    Thread.sleep(1000)
//
//    println("Main End")
//}

//or
fun main() = runBlocking<Unit> {
    println("Run Blocking Start\n")

    val resultList = mutableListOf<String>() //Avoid Sharing mutable data state

 /*   val job1 = launch {
        val result = doNetworkRequest(1)
        resultList.add(result)          //Avoid Sharing mutable data state
    }
    val job2 = launch {
        val result = doNetworkRequest(2)
        resultList.add(result)       //Avoid Sharing mutable data state
    }

    job1.join() //this code is wait  when completed first Job
    job2.join()
    */

    val job3 = async {
        return@async doNetworkRequest(3)  //here is avoid sharing mutable data state
    }
    val job4 = async {
        return@async doNetworkRequest(4)
    }
    resultList.add(job3.await())
    resultList.add(job4.await())

    println("Result is: $resultList\n")
    println("Run Blocking complete\n")

}

suspend fun doNetworkRequest(number:Int): String {
    println("Some work Started")
    delay(500)
    return "Network Request $number completed"
}
