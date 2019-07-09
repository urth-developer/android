package com.example.urthlesh.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_category_detail.*



class CategoryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.urthlesh.R.layout.activity_category_detail)
        btn_back_category_detail.setOnClickListener {
            finish()
        }
        txt_category_title.text = intent.getStringExtra("title")
        val img_url = intent.getStringExtra("main_img")
        Glide.with(this).load(img_url).into(img_category_detail_main)
    }
}




