package com.example.urthlesh.Mypage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.toolbar_introduce.*

class IntroduceServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduce_service)

        introduce_back.setOnClickListener{
            finish()
        }
    }
}
