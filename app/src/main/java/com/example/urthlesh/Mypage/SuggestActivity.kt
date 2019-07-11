package com.example.urthlesh.Mypage

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.urthlesh.Fragment.MypageFragment
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_suggest.*
import kotlinx.android.synthetic.main.toolbar_suggest.*
import kotlinx.android.synthetic.main.toolbar_terms.*

class SuggestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggest)

        suggest_back.setOnClickListener{
            finish()
        }

    }
}
