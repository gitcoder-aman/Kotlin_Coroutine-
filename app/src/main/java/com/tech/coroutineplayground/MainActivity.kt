package com.tech.coroutineplayground

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.tech.coroutineplayground.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var imageView:ImageView
    private lateinit var loadBtn:Button

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
         imageView = findViewById(R.id.imageView)
         loadBtn = findViewById(R.id.button)

        loadBtn.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {

                try{
                    Log.d("MYTAG","onCreate Thread Name: ${Thread.currentThread().name}")
                    val url = URL("https://i.redd.it/bfc0pz8qdji61.jpg")

                    val bitmap = BitmapFactory.decodeStream(url.openStream())

                    withContext(Dispatchers.Main){
                        Log.d("MYTAG","onCreate WithContext: Thread Name: ${Thread.currentThread().name}")
                        imageView.setImageBitmap(bitmap)
                    }
                }catch (e:Exception){
                    Log.d("MYTAG","OnCreate: $e")
                }


            }

        }
    }
}