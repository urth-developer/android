package com.example.urthlesh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_category_detail.*
import kotlinx.android.synthetic.main.activity_create_title.*

class CategoryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_detail)
        btn_back_category_detail.setOnClickListener {
            finish()
        }

        txt_category_title.text = intent.getStringExtra("title")
    }
}




