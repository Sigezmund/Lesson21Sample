package com.teachmeskills.lesson21sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.teachmeskills.lesson21sample.log.log

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log(this, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        log(this, "onStart")
    }

    override fun onResume() {
        super.onResume()
        log(this, "onResume")
    }

    override fun onPause() {
        super.onPause()
        log(this, "onPause")
    }

    override fun onStop() {
        super.onStop()
        log(this, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        log(this, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        log(this, "onRestart")
    }
}