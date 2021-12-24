package com.teachmeskills.lesson21sample.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.teachmeskills.lesson21sample.databinding.ActivitySelectColorBinding

class SelectColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySelectColorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.green.setOnClickListener {
            sendResult("green")
        }
        binding.red.setOnClickListener {
            sendResult("red")
        }
        binding.yellow.setOnClickListener {
            sendResult("yellow")
        }
    }

    private fun sendResult(message: String) {
        setResult(RESULT_OK, Intent().apply {
            putExtra(EXTRA, message)
        })
        finish()
    }


    companion object {
        const val EXTRA = "extra_key"
    }
}