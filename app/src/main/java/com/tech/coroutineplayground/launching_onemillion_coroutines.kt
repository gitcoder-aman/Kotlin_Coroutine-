package com.tech.coroutineplayground

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main(){
    //Many coroutines (even a million) can run on a single thread
    //But coroutines are not threads
    //Coroutines runs inside a threads
//    millionOfCoroutines()
    millionOfThreads()
}
//millions of coroutines on a thread
fun millionOfCoroutines()= runBlocking{
    println("Thread Name : ${Thread.currentThread().name}")
    repeat(1_000_000){
        launch {
            delay(3000)
            print(".")
        }
    }
}
//we don't create unlimited thread in OS they throw outOFMemory Exception
fun millionOfThreads(){
    println("Thread Name : ${Thread.currentThread().name}")
    repeat(1_000_000){
        thread {
            Thread.sleep(3000)
            print(".")
        }
    }
}