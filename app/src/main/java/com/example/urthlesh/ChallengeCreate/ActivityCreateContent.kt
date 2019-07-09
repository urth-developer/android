package com.example.urthlesh.ChallengeCreate

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_create_content.*
import kotlinx.android.synthetic.main.activity_create_title.*

class ActivityCreateContent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_content)

        btn_back_create_content.setOnClickListener{
            setResult(Activity.RESULT_OK)
            finish()
        }
        btn_cancel_create_content.setOnClickListener {
            setResult(Activity.RESULT_FIRST_USER)
            finish()
        }
        btn_next_create_content.setOnClickListener{
            val createnextphoto = Intent(this, ActivityCreatePhoto::class.java);
            startActivityForResult(createnextphoto, 127)
        }

        fun View.hideKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }

    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 127){
            if(resultCode == Activity.RESULT_FIRST_USER){
                finish()
            }
        }
    }
}
