package com.example.urthlesh.ChallengeCreate

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_create_title.*
import kotlinx.android.synthetic.main.fragment_allurth.*
import org.jetbrains.anko.startActivityForResult

class ActivityCreateTitle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_title)

        btn_cancel.setOnClickListener {
            finish()
        }

        btn_back.setOnClickListener{
            finish()
        }
        btn_next.setOnClickListener{
            val createnextcategory = Intent(this, ActivityCreateCategory::class.java);
            startActivityForResult(createnextcategory, 127)
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
