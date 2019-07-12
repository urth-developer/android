package com.example.urthlesh.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.urthlesh.Data.ChallengeData
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.GetChallengeDetailResponse
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_challenge_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChallengeDetailActivity : AppCompatActivity() {
    lateinit var title: String
    //lateinit var ChallengeIdx:Int

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }
    var challengeDetail: ChallengeData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge_detail)

        var title = intent.getStringExtra("title")
        txt_challenge_detail_title.text = title

        btn_back_challenge_detail.setOnClickListener {
            finish()
        }

        getChallengeDetailResponse()

    }

    private fun getChallengeDetailResponse() {

        val getChallengeDetailResponse = networkService.getChallengeDetailResponse(
            "application/json"
        )
        getChallengeDetailResponse.enqueue(object : Callback<GetChallengeDetailResponse>{
            override fun onFailure(call: Call<GetChallengeDetailResponse>, t: Throwable) {
                Log.e("챌린지 상세보기 실패", t.toString())
            }

            override fun onResponse(
                call: Call<GetChallengeDetailResponse>,
                response: Response<GetChallengeDetailResponse>
            ) {
                Log.v("hee1","통신 시작")
                if(response.isSuccessful){
                    if(response.body()!!.status == 200){
                        challengeDetail = response.body()!!.data

                       // ChallengeIdx= intent.getStringExtra("challengeidx")
                        /*txt_challenge_detail_title.text=challengeDetail.name
                        txt_challenge_detail_creator.text=challengeDetail.creator*/
                    }
                }
            }

        })
    }

}
