package com.example.urthlesh.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.urthlesh.Adapter.CommentAdapter
import com.example.urthlesh.Data.ChallengeComment
import com.example.urthlesh.Data.ChallengeDetailData
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.GetChallengeDetailResponse
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_category_detail.*
import kotlinx.android.synthetic.main.activity_challenge_detail.*
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChallengeDetailActivity : AppCompatActivity() {
    lateinit var title: String
    var ChallengeIdx: Int =2
    lateinit var commentAdapter:CommentAdapter

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }
    // var challengeDetailData: ChallengeDetailData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge_detail)


        ChallengeIdx = intent.getIntExtra("challengeIdx",11)

        btn_back_challenge_detail.setOnClickListener {
            finish()
        }


        var commentList:ArrayList<ChallengeComment> = ArrayList()
        commentList.add(ChallengeComment(
            "https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045",
            "용이 누나","어스 멋져용~~ 에코 챌린지 화이팅 화이팅 화이팅 화이팅 화이팅 화이팅"
        ))
        commentList.add(ChallengeComment(
            "https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045",
            "용이 누나","어스 멋져용~~ 에코 챌린지 화이팅 화이팅 화이팅 화이팅 화이팅 화이팅"
        ))
        commentList.add(ChallengeComment(
            "https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045",
            "용이 누나","어스 멋져용~~ 에코 챌린지 화이팅 화이팅 화이팅 화이팅 화이팅 화이팅"
        ))
        commentList.add(ChallengeComment(
            "https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045",
            "용이 누나","어스 멋져용~~ 에코 챌린지 화이팅 화이팅 화이팅 화이팅 화이팅 화이팅"
        ))
        commentList.add(ChallengeComment(
            "https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045",
            "용이 누나","어스 멋져용~~ 에코 챌린지 화이팅 화이팅 화이팅 화이팅 화이팅 화이팅"
        ))
        commentAdapter = CommentAdapter(this,commentList)
        rv_comment.adapter = commentAdapter
        val lm = LinearLayoutManager(this)
        rv_comment.layoutManager = lm
        rv_comment.setHasFixedSize(true)


        getChallengeDetailResponse()

    }

    private fun getChallengeDetailResponse() {

        val getChallengeDetailResponse = networkService.getChallengeDetailResponse(
            "application/json","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjE0LCJpYXQiOjE1NjI4NTE4MDQsImV4cCI6MTU5NDM4NzgwNCwiaXNzIjoic29wdG9vbiJ9.MQG9COi4a5aNQLPPjkwfICNow30mBopyj1M6W2E03fA",
            ChallengeIdx
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
                    Log.d("123",response.body().toString())
                    if(response.body()!!.status == 200){
                        val challengeDetailData = response.body()!!.data!!
                        Log.v("hee1",challengeDetailData.toString())


                        txt_challenge_detail_title.setText(challengeDetailData.name)
                        txt_challenge_detail_creator.setText(challengeDetailData.creator)
                        txt_challenge_detail_participatenum.setText(challengeDetailData.participantCount.toString() + "명 참여중")
                        txt_challenge_detail_totalnum.setText("총 " + challengeDetailData.count.toString() + "회")
                        txt_challenge_detail_num.setText(challengeDetailData.userSuccessCount.toString() + "회 인증")
                        txt_challenge_detail_content.setText(challengeDetailData.explanation)
                        

                    }
                }
            }

        })
    }

}
