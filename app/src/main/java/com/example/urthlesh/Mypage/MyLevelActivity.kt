package com.example.urthlesh.Mypage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.toolbar_my_level.*

class MyLevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_level)

        my_level_back.setOnClickListener{
            finish()
        }
    }


}
