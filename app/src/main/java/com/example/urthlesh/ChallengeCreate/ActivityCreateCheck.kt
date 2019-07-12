package com.example.urthlesh.ChallengeCreate

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_create_category.*
import kotlinx.android.synthetic.main.activity_create_check.*
import kotlinx.android.synthetic.main.activity_create_content.*
import android.graphics.BitmapFactory
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ImageView


class ActivityCreateCheck : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_check)

        txt_create_challenge_title.text=intent.getStringExtra("createtitle")
        txt_create_challenge_category.text=intent.getStringExtra("createcategory")
        txt_create_challenge_content.text=intent.getStringExtra("createcontent")

        val arr = getIntent().getByteArrayExtra("createphoto")
        Log.d("arr", arr.toString())
        val getimage = BitmapFactory.decodeByteArray(arr, 0, arr.size)
        val BigImage = findViewById<View>(R.id.img_create_challenge_image) as ImageView
        BigImage.setImageBitmap(getimage)


        btn_back_create_check.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
        btn_cancel_create_check.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        btn_finish_create_check.setOnClickListener {
            val createfinishcheck = Intent(this, ActivityCreateComplete::class.java);
            startActivityForResult(createfinishcheck, 127)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 127){
            if(resultCode == Activity.RESULT_CANCELED){
                finish()
            }
        }
    }



}

