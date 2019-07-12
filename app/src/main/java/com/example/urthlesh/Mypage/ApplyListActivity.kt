package com.example.urthlesh.Mypage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.urthlesh.Adapter.ApplyListAdapter
import com.example.urthlesh.Data.ApplyListData
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.GetApplyListResponse
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_apply_list.*
import kotlinx.android.synthetic.main.toolbar_apply_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApplyListActivity : AppCompatActivity() {

    val networkService: NetworkService by lazy{
        ApplicationController.instance.networkService
    }
    lateinit var applyListAdapter: ApplyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_list)

        var dataList: ArrayList<ApplyListData> = ArrayList()

//        dataList.add(
//            ApplicationDetailData(
//                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
//                "챌린지이름",
//                "20",
//                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"
//            )
//        )

        applyListAdapter = ApplyListAdapter(this,dataList)
        rvrv_.adapter = applyListAdapter
        rvrv_.layoutManager = LinearLayoutManager(this)

        getApplyListResponse()

        apply_list_back.setOnClickListener{
            finish()
        }


    }

    private fun getApplyListResponse(){
        val getApplyListResponse = networkService.getApplyListResponse("application/json","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjE0LCJpYXQiOjE1NjI4NTE4MDQsImV4cCI6MTU5NDM4NzgwNCwiaXNzIjoic29wdG9vbiJ9.MQG9COi4a5aNQLPPjkwfICNow30mBopyj1M6W2E03fA")
        getApplyListResponse.enqueue(object: Callback<GetApplyListResponse>{
            override fun onFailure(call: Call<GetApplyListResponse>, t:Throwable){
                Log.e("Fail",t.toString())
            }

            override fun onResponse(
                call:Call<GetApplyListResponse>,
                response: Response<GetApplyListResponse>
            ){
                if(response.isSuccessful){
                    if(response.body()!!.status==200){
                        val tmp:ArrayList<ApplyListData> = response.body()!!.data!!
                        applyListAdapter.applyList=tmp
                        applyListAdapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }
}
