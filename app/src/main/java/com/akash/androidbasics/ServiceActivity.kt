package com.akash.androidbasics

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.akash.androidbasics.databinding.ActivityServiceBinding


class ServiceActivity : AppCompatActivity() {
    lateinit var binding: ActivityServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.startService.setOnClickListener {
            startService(Intent(it.context,ForeGroundService::class.java))
        }

        binding.stopService.setOnClickListener{
            stopService(Intent(it.context,ForeGroundService::class.java))
        }
    }
}