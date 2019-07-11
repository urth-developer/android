package com.example.urthlesh.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_add_friend.*
import kotlinx.android.synthetic.main.toolbar_addfriend.*

class AddFriendActivity : AppCompatActivity() {

    lateinit var friendname: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_friend)

        btn_addfriend_back.setOnClickListener {
            finish()
        }
        btn_search_friend.setOnClickListener {
            friendname = edt_search_friendname.text.toString()
            if(friendname=="jina")
            {

            }
            //intent.getStringExtra("nickname")


        }


    }
}