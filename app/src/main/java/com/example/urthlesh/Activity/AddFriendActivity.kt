package com.example.urthlesh.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.urthlesh.DB.SharedPreferenceControler
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.GetFriendSearchResponse
import com.example.urthlesh.R
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_add_friend.*
import kotlinx.android.synthetic.main.toolbar_addfriend.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddFriendActivity : AppCompatActivity() {

    lateinit var friendname: String

    val networkService: NetworkService by lazy{
        ApplicationController.instance.networkService
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_friend)

       btn_addfriend_back.setOnClickListener {
            finish()
        }

       /* btn_search_friend.setOnClickListener {
            val friendname = edt_search_friendname.text.toString()
            getPostSearchFriendResult(friendname)


        }*/}




    /*fun   getPostSearchFriendResult(friend_name:String){
        var jsonObject=JSONObject()
        jsonObject.put("nickname",friend_name)
        val gsonObject=JsonParser().parse(jsonObject.toString()) as JsonObject
        //바디가 필요한 경우 위까지
        val getFriendSearchResponse: Call<GetFriendSearchResponse> = networkService.getFriendSearchResponse("application/json",SharedPreferenceControler.getUseToken(this),gsonObject)
        getFriendSearchResponse.enqueue(object :Callback<GetFriendSearchResponse> {
            override fun onFailure(call: Call<GetFriendSearchResponse>, t: Throwable) {
                Log.e("lar", "실패했당")
            }

           *//* override fun onResponse(call: Call<GetFriendSearchResponse>, response: Response<GetFriendSearchResponse>) {
                Log.e("lar", "응답왔당")
                if (response.isSuccessful)
                    {
                        if(response.body()!!.status == 200) {
                        Log.v("large",response.body()!!.message)
                        img_find_friend.visibility = View.VISIBLE
                        txt_cannot_find_friend.visibility = View.INVISIBLE
                    } else if (response.body()!!.status == 404) {
                        Log.v("large",response.body()!!.message)
                        txt_cannot_find_friend.visibility = View.VISIBLE
                        img_find_friend.visibility = View.INVISIBLE

                    }else{
                        Log.v("large",response.body()!!.message)
                    }
                }//Successful


            }*//*

            })
          }*/
    }

