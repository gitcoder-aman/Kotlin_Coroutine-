package com.tech.coroutineplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tech.coroutineplayground.databinding.ActivityMainBinding
import com.tech.coroutineplayground.databinding.ActivitySuspendingBlockingCallActvityBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigInteger

class Suspending_BlockingCallActvity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySuspendingBlockingCallActvityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        binding.button.setOnClickListener {
//            Thread.sleep(3000) // here is thread blocking call block UI in 3 sec
//            showMessage()
//        }
//        binding.button.setOnClickListener {
//            CoroutineScope(Dispatchers.Main.immediate).launch { //Main UI(thread) is free
//                delay(3000)
//                showMessage() // here is coroutine suspending call
//            }
//        }
        binding.button.setOnClickListener {
            CoroutineScope(Dispatchers.Main.immediate).launch { //Main UI is free
                val number = findBigPrime()
                Log.d("MYTAG",number.toString())
            }
        }
    }

    private suspend fun showMessage() {
        findBigPrime()
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
    }

    suspend fun findBigPrime(): BigInteger = withContext(Dispatchers.Default) {//in background
        BigInteger.probablePrime(4096, java.util.Random())
    }
}