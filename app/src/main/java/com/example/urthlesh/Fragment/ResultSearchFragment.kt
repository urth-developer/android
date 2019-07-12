package com.example.urthlesh.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.urthlesh.Adapter.RVChallengeAdapter
import com.example.urthlesh.Data.ChallengeData
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.GetSearchChallengeResponse

import com.example.urthlesh.R
import kotlinx.android.synthetic.main.fragment_result_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultSearchFragment : Fragment() {
    lateinit var rvChallengeAdapter: RVChallengeAdapter
    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var challenge_search_list: ArrayList<ChallengeData> = ArrayList()

        rvChallengeAdapter = RVChallengeAdapter(context!!, challenge_search_list)
        rv_result_search.adapter = rvChallengeAdapter
        val lm = LinearLayoutManager(context!!)
        rv_result_search.layoutManager = lm
        rv_result_search.setHasFixedSize(true)
        getCategoryChallengeListResponse()
    }

    private fun getCategoryChallengeListResponse() {


        val getCategoryChallengeListResponse = networkService.getSearchCallengeResponse(
            "application/json"
        )
        getCategoryChallengeListResponse.enqueue(object : Callback<GetSearchChallengeResponse> {
            override fun onFailure(call: Call<GetSearchChallengeResponse>, t: Throwable) {
                Log.e("검색결과가 없습니다.", t.toString())
            }

            override fun onResponse(
                call: Call<GetSearchChallengeResponse>,
                response: Response<GetSearchChallengeResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.status == 200) {
                        val tmp: ArrayList<ChallengeData> = response.body()!!.data!!
                        rvChallengeAdapter.challengeList = tmp
                        rvChallengeAdapter.notifyDataSetChanged()
                    }
                }
            }

        })

    }


}
