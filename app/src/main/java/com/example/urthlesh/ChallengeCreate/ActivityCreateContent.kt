package com.example.urthlesh.ChallengeCreate

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_create_content.*
import kotlinx.android.synthetic.main.activity_create_title.*

class ActivityCreateContent : AppCompatActivity() {
    lateinit var createtitle:String
    lateinit var createcategory:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_content)

        createtitle= intent.getStringExtra("createtitle")
        createcategory= intent.getStringExtra("createcategory")

        btn_back_create_content.setOnClickListener{
            setResult(Activity.RESULT_OK)
            finish()
        }
        btn_cancel_create_content.setOnClickListener {
            setResult(Activity.RESULT_FIRST_USER)
            finish()
        }
        btn_next_create_content.setOnClickListener{
            val create_content = edit_txt_content.text.toString()
            if (create_content == "")
                edit_txt_content.requestFocus()
            else {
                val createnextphoto = Intent(this, ActivityCreatePhoto::class.java);
                val createcontent:String = edit_txt_content.getText().toString();

                createnextphoto.putExtra("createtitle",createtitle)
                createnextphoto.putExtra("createcategory",createcategory)
                createnextphoto.putExtra("createcontent",createcontent)
                startActivityForResult(createnextphoto, 127)
                Log.v("honigetcategory",createcategory)
            }

        }

        fun View.hideKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
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
