package com.example.urthlesh.Fragment


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.urthlesh.Activity.AddFriendActivity
import com.example.urthlesh.Adapter.FriendListAdapter
import com.example.urthlesh.DB.SharedPreferenceControler
import com.example.urthlesh.Data.FriendData
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.GetUserDataResponse
import com.example.urthlesh.Network.Post.GetUserResponse

import com.example.urthlesh.R
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.fragment_friend_usurth.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"




class FriendUsurthFragment : Fragment() {

    lateinit var friendListAdapter: FriendListAdapter



    val networkService : NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friend_usurth, container, false)
    }


    /*

        {  val getFriendResponse : Call<GetUserResponse> = networkService.getFriendResponse("application/json",SharedPreferenceControler.getUseToken(context!!))
            getFriendResponse.enqueue(object: Callback<GetUserResponse>{
                override fun onFailure(call: Call<GetUserResponse>, t: Throwable) {
                    Log.e("친구조회 실패",t.toString())
                }

                override fun onResponse(call: Call<GetUserResponse>, response: Response<GetUserResponse>) {
                    if(response.isSuccessful){
                        //toast(response.body()!!.message)
                        if(response.body()!!.status == 200 )
                        {  override fun onResponse(call: Call<GetFriendResponse>,
                                                   response: Response<GetFriendResponse>)
                        {if(response.isSuccessful)
                        {if(response.body()!!.status ==200
                            {val tmp: ArrayList<GetUserDataResponse> = response.body()!!.data!!
                                friendListAdapter.friendList = tmp
                                friendListAdapter.notifyDataSetChanged()
                            })}}
                    }
                }

                }

                )
        }
    */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var friendList: ArrayList<GetUserDataResponse> = ArrayList()
        btn_friend_add.setOnClickListener {
            var myintent = Intent(activity, AddFriendActivity::class.java);
            context!!.startActivity(myintent)
        }
        friendListAdapter = FriendListAdapter(context!!, friendList)
        rv_friend_list.adapter = friendListAdapter
        rv_friend_list.layoutManager = GridLayoutManager(context!!, 2)

        getFriendResponse() }
    /* FriendList.add(
         FriendData(
             "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝둥이", 1
         )
     )
     FriendList.add(
         FriendData(
             "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝순이", 2
         )
     )
     FriendList.add(
         FriendData(
             "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝솝이", 30
         )
     )
     FriendList.add(
         FriendData(
             "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝기요미", 4
         )
     )
     FriendList.add(
         FriendData(
             "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "숩둔이", 1
         )
     )
     FriendList.add(
         FriendData(
             "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝동이", 2
         )
     )
     FriendList.add(
         FriendData(
             "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝둉이", 5
         )
     )
     FriendList.add(
         FriendData(
             "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝똥이", 3
         )
     )
     FriendList.add(
         FriendData(
             "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝둥이", 7
         )
     )
     FriendList.add(
         FriendData(
             "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝둥이", 2
         )
     )*/




    private fun getFriendResponse(){
        val getFriendResponse = networkService.getFriendResponse(
            "application/json",SharedPreferenceControler.getUseToken(context!!))
        getFriendResponse.enqueue(object: Callback<GetUserResponse>{
            override fun onFailure(call: Call<GetUserResponse>, t: Throwable) {
                Log.v("large","fail")
            }

            override fun onResponse(
                call: Call<GetUserResponse>,
                response: Response<GetUserResponse>)
            {
                Log.v("large","통신시작")
                if(response.isSuccessful)
                {
                    if(response.body()!!.status == 200)
                    {   var tmp:ArrayList<GetUserDataResponse> = response.body()!!.data!!
                        Log.v("large",tmp.toString())
                        //newDataList.addAll(response.body()!!.data)
                        //friendListAdapter.friendList,clear()
                        //frienListAdapter.friendList=tmp
                        //challengeRecyclerViewMainAdapter.dataList.clear()
                        friendListAdapter.friendList = tmp
                        friendListAdapter.notifyDataSetChanged()
                    }
                }
            }

        })
//            {Log.e("friend fail",t.toString())
//            }
//
//            override fun onResponse(
//                call: Call<GetUserResponse>,
//                response: Response<GetUserResponse>
//            ) {
//                if(response.isSuccessful{
//                        if(response.body()!!.status == 200)
//                        {val tmp: ArrayList<GetUserDataResponse> = response.body()!!.data!!
//                          friendListAdapter.friendList = tmp
//                          friendListAdapter.notifyDataSetChanged() } )}}
//



    }
}
