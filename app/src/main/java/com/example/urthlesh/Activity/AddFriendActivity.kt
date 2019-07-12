package com.example.urthlesh.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_add_friend.*
import kotlinx.android.synthetic.main.toolbar_addfriend.*

class AddFriendActivity : AppCompatActivity() {

    lateinit var friendname: String

    val networkService: NetworkService by lazy{
        ApplicationController.instance.networkService
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_friend)

      /*  btn_addfriend_back.setOnClickListener {
            finish()
        }
        btn_search_friend.setOnClickListener {
            val friendname = edt_search_friendname.text.toString()
            val


        }*/


    }
}