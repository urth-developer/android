package com.example.urthlesh.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import cdflynn.android.library.turn.TurnLayoutManager
import com.example.urthlesh.Activity.MyChallengeDetailActivity
import com.example.urthlesh.Adapter.ChallengeRecyclerViewMainAdapter
import com.example.urthlesh.Adapter.IndicatorAdapter
import com.example.urthlesh.Adapter.RVChallengeAdapter
import com.example.urthlesh.Data.ChallengeData
import com.example.urthlesh.Data.HomechallengeData

import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.rv_item_main_challenge.*
import org.jetbrains.anko.startActivity


class HomeFragment : Fragment() {
    lateinit var challengeRecyclerViewMainAdapter: ChallengeRecyclerViewMainAdapter
    lateinit var rvChallengeAdapter:RVChallengeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.urthlesh.R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnHomeSync.setOnClickListener {
           context!!.startActivity<MyChallengeDetailActivity>()
        }
        var dataList: ArrayList<HomechallengeData> = ArrayList()
        var ChallengeDataList: ArrayList<ChallengeData> = ArrayList()


        dataList.add(
            HomechallengeData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png" ,""
                ))
        dataList.add(
            HomechallengeData(
               "https://image.shutterstock.com/z/stock-vector-vector-flat-illustration-little-men-prepare-for-the-day-of-the-earth-save-the-planet-save-energy-1060898801.jpg",
            "챌린지 1"))
        dataList.add(
            HomechallengeData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
             "챌린지 2"))
        dataList.add(
            HomechallengeData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
             "챌린지 3"))
        dataList.add(
            HomechallengeData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            "챌린지 4"))
        dataList.add(
            HomechallengeData(
                "",
                ""))
            // 오늘의 챌린지
        ChallengeDataList.add(
            ChallengeData(
                "https://image.shutterstock.com/z/stock-vector-vector-flat-illustration-little-men-prepare-for-the-day-of-the-earth-save-the-planet-save-energy-1060898801.jpg",
                "챌린지 1","eunbin",4))
        ChallengeDataList.add(
            ChallengeData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지 2","jisoo",5))
        ChallengeDataList.add(
            ChallengeData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지 3","Manhyeuk",4))
        challengeRecyclerViewMainAdapter= ChallengeRecyclerViewMainAdapter(context!!,dataList)
        rv_home_challenge.adapter=challengeRecyclerViewMainAdapter
                rv_home_challenge.layoutManager=TurnLayoutManager(context!!,TurnLayoutManager.Gravity.START,TurnLayoutManager.Orientation.HORIZONTAL,1200,200,true)
    rvChallengeAdapter= RVChallengeAdapter(context!!,ChallengeDataList)
        rv_home_todayChallenge.adapter=rvChallengeAdapter
        rv_home_todayChallenge.layoutManager=LinearLayoutManager(context!!)

         val indexAdapter = IndicatorAdapter(context!!, dataList)
        rv_home_dot.adapter=indexAdapter
        rv_home_dot.layoutManager=LinearLayoutManager(context!!,LinearLayout.HORIZONTAL,false)
        val snapHelper=LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_home_challenge)
        rv_home_challenge.onFlingListener=snapHelper

        rv_home_challenge.addOnScrollListener(object:RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                indexAdapter.setItenIndex(
                    (recyclerView.layoutManager as LinearLayoutManager)
                        .findFirstVisibleItemPosition()
                )


            }
        })
    }


}
