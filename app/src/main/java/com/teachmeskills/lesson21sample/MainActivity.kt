package com.teachmeskills.lesson21sample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.teachmeskills.lesson21sample.databinding.ActivityMainBinding
import com.teachmeskills.lesson21sample.activity.SelectColorActivity
import com.teachmeskills.lesson21sample.fragment.ColorSampleActivity
import com.teachmeskills.lesson21sample.transparent.TransparentActivity

class MainActivity : BaseActivity() {

    val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            val resultCode = activityResult.resultCode
            val data = activityResult.data
            if (resultCode == RESULT_OK) {
                Toast.makeText(
                    this,
                    data?.getStringExtra(SelectColorActivity.EXTRA),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ActivityMainBinding.inflate(layoutInflater)

        setContentView(view.root)
        with(view) {
            openTransparentScreen.setOnClickListener {
                // Открытие прозрачной активити
                startActivity(Intent(this@MainActivity, TransparentActivity::class.java))
            }


            selectColorNewWay.setOnClickListener {
                // Новый способ получения  информации из другой activity
                getContent.launch(Intent(this@MainActivity, SelectColorActivity::class.java))
            }

            openNextActivityOldWay.setOnClickListener {
                // Старый способ получения  информации из другой activity
                startActivityForResult(
                    Intent(this@MainActivity, SelectColorActivity::class.java),
                    SELECT_COLOR_REQUEST_CODE
                )
            }

            openFragmentSample.setOnClickListener {
                startActivity(Intent(this@MainActivity, ColorSampleActivity::class.java))
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                PHOTO_REQUEST_CODE -> {}
                SELECT_COLOR_REQUEST_CODE -> {
                    Toast.makeText(
                        this,
                        data?.getStringExtra(SelectColorActivity.EXTRA),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    companion object {
        private val SELECT_COLOR_REQUEST_CODE = 11
        private val PHOTO_REQUEST_CODE = 12
    }
}