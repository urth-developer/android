package com.example.urthlesh.ChallengeCreate

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_create_title.*

class ActivityCreateCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_category)

        btn_back.setOnClickListener{
            setResult(Activity.RESULT_OK)
            finish()
        }
        btn_cancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
        btn_next.setOnClickListener{
            val createnextcontent = Intent(this, ActivityCreateContent::class.java);
            startActivityForResult(createnextcontent, 127)
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
