package com.teachmeskills.lesson21sample.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.teachmeskills.lesson21sample.R

class ColorSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_sample)
        if (savedInstanceState == null) {
            val fragment = ColorsMainFragment.newInstance()
            // Добавляем fragment
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment, "tag")
                //Не забываем вызывать commit()
                .commit()
        }


    }


}