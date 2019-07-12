package com.example.urthlesh.Activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.bumptech.glide.Glide
import com.example.urthlesh.Adapter.RVChallengeAdapter
import com.example.urthlesh.Data.ChallengeData
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.GetCategoryChallengeListResponse
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_category_detail.*
import kotlinx.android.synthetic.main.fragment_allurth.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoryDetailActivity : AppCompatActivity() {
    lateinit var rvChallengeAdapter: RVChallengeAdapter
    var categoryflag: Int = 1
    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }
    var challengeList: ArrayList<ChallengeData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.urthlesh.R.layout.activity_category_detail)
        btn_back_category_detail.setOnClickListener {
            finish()
        }

        txt_category_title.text = intent.getStringExtra("title")
        img_category_detail_main.setImageResource(intent.getIntExtra("main_img", R.drawable.img_category_dispoable))


        getCategoryChallengeListResponse()

        val lm = LinearLayoutManager(this)
        rv_challenge_category.layoutManager = lm
        rv_challenge_category.setHasFixedSize(true)
        //getCategoryChallengeListResponse()

        if (txt_category_title.text == "일회용품") {
            categoryflag = 1
        } else if (txt_category_title.text == "대기") {
            categoryflag = 2
        } else if (txt_category_title.text == "자원") {
            categoryflag = 3
        } else if (txt_category_title.text == "수질") {
            categoryflag = 4
        } else categoryflag = 5
    }


    private fun getCategoryChallengeListResponse() {


        val getCategoryChallengeListResponse = networkService.getCategoryChallengeListResponse(
            "application/json", categoryflag
        )
        getCategoryChallengeListResponse.enqueue(object : Callback<GetCategoryChallengeListResponse> {
            override fun onFailure(call: Call<GetCategoryChallengeListResponse>, t: Throwable) {
                Log.e("카테고리별 챌린지 리스트 조회 실패", t.toString())
            }

            override fun onResponse(
                call: Call<GetCategoryChallengeListResponse>,
                response: Response<GetCategoryChallengeListResponse>
            ) {
                Log.v("hee1","통신 시작")
                if (response.isSuccessful) {
                    //reponse 덩어리 = response.body()
                    if (response.body()!!.status == 200) {

                        val tmp: ArrayList<ChallengeData> = response.body()!!.data!!
                        Log.v("hee1",tmp.toString())
                        challengeList = tmp
                        //rvChallengeAdapter.challengeList = tmp
                        rvChallengeAdapter = RVChallengeAdapter(applicationContext,challengeList)
                        rv_challenge_category.adapter = rvChallengeAdapter
                        rvChallengeAdapter.notifyDataSetChanged()


                    }
                }
            }

        })

    }
}
