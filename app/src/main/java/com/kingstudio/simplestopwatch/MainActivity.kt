package com.kingstudio.simplestopwatch

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kingstudio.simplestopwatch.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding:  ActivityMainBinding

    var seconds = 0
    var isRunning = false
    var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        binding.btnStart.setOnClickListener {

            if(!isRunning)
            {
                isRunning = true

                job = CoroutineScope(Dispatchers.Main).launch {

                    while (isRunning)
                    {
                        delay(1000)
                        seconds++
                        binding.txtTime.text = seconds.toString()
                    }
                }
            }
        }

        binding.btnStop.setOnClickListener {

            isRunning = false
            job?.cancel()
        }

        binding.btnReset.setOnClickListener {

            isRunning = false
            job?.cancel()
            seconds = 0
            binding.txtTime.text = "0"
        }

    }
}