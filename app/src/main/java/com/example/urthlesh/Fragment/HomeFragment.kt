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
import com.example.urthlesh.DB.SharedPreferenceControler
import com.example.urthlesh.Data.ChallengeData
import com.example.urthlesh.Data.HomechallengeData
import com.example.urthlesh.Data.MyChallengeData
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.CategoryHomeData
import com.example.urthlesh.Network.Post.GetUrthResultHomeResponse
import com.example.urthlesh.Network.Post.PostMyChallengeDetailResponse
import com.example.urthlesh.Network.Post.PostMyFavoriteChallengeHomeResponse
import com.example.urthlesh.custom_camera.CameraActivity

import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.rv_item_main_challenge.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    lateinit var challengeRecyclerViewMainAdapter: ChallengeRecyclerViewMainAdapter
    lateinit var rvChallengeAdapter:RVChallengeAdapter
    lateinit var UrthResultHomeDataList:ArrayList<Int>
    lateinit var dataList: ArrayList<HomechallengeData>
    lateinit var ChallengeDataList: ArrayList<ChallengeData>
    val networkService: NetworkService by lazy{
        ApplicationController.instance.networkService
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.urthlesh.R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //카메라 실행되는 버튼
        btnHomeSync.setOnClickListener {
           context!!.startActivity<CameraActivity>()
        }

        dataList= ArrayList()
        ChallengeDataList = ArrayList()

//
//        dataList.add(
//            HomechallengeData(
//                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png" ,""
//                ))
//        dataList.add(
//            HomechallengeData(
//               "https://image.shutterstock.com/z/stock-vector-vector-flat-illustration-little-men-prepare-for-the-day-of-the-earth-save-the-planet-save-energy-1060898801.jpg",
//            "챌린지 1"))
//        dataList.add(
//            HomechallengeData(
//            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
//             "챌린지 2"))
//        dataList.add(
//            HomechallengeData(
//            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
//             "챌린지 3"))
//        dataList.add(
//            HomechallengeData(
//            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
//            "챌린지 4"))
//        dataList.add(
//            HomechallengeData(
//                "",
//                ""))
            // 오늘의 챌린지
        ChallengeDataList.add(
            ChallengeData(
                1,"challenge1 explanation",1,"https://image.shutterstock.com/z/stock-vector-vector-flat-illustration-little-men-prepare-for-the-day-of-the-earth-save-the-planet-save-energy-1060898801.jpg",
                "챌린지 1","eunbin",4))
        ChallengeDataList.add(
            ChallengeData(
                2,"challenge2 explanation",2,"http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지 2","jisoo",5))
        ChallengeDataList.add(
            ChallengeData(
                3,"challenge3 explanation",3,"http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지 3","Manhyeuk",10))
          UrthResultHomeDataList= ArrayList()
        challengeRecyclerViewMainAdapter= ChallengeRecyclerViewMainAdapter(context!!,dataList)
        rv_home_challenge.adapter=challengeRecyclerViewMainAdapter
        rv_home_challenge.layoutManager=TurnLayoutManager(context!!,TurnLayoutManager.Gravity.START,TurnLayoutManager.Orientation.HORIZONTAL,1200,200,true)
        getHomehallengeDataList()
        ///////
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

       getCategoryHomeDataListResponse()




    }
    private fun getCategoryHomeDataListResponse(){
        val getUrthResultHomeResponse=networkService.getUrhResultHomeResponse("application/json")

        getUrthResultHomeResponse.enqueue(object: Callback<GetUrthResultHomeResponse>{
            override fun onFailure(call: Call<GetUrthResultHomeResponse>, t: Throwable) {
                Log.v("eeeee","페일페일")
                Log.e("UrthResulDataList Fail",t.toString())
            }

            override fun onResponse(
                call: Call<GetUrthResultHomeResponse>,
                response: Response<GetUrthResultHomeResponse>
            ) {
                if (response.isSuccessful){

                    if(response.body()!!.status==200)
                    {
                        UrthResultHomeDataList.add(response.body()!!.data!!.authCountsByCategory!!.category1)
                        UrthResultHomeDataList.add(response.body()!!.data!!.authCountsByCategory!!.category2)
                        UrthResultHomeDataList.add(response.body()!!.data!!.authCountsByCategory!!.category3)
                        UrthResultHomeDataList.add(response.body()!!.data!!.authCountsByCategory!!.category4)
                        UrthResultHomeDataList.add(response.body()!!.data!!.authCountsByCategory!!.category5)


                        home_comment_people.text=response.body()!!.data!!.totalUserCount.toString()+"명의 사람들과 함께"
                        home_comment_turtle.text="바다거북"+UrthResultHomeDataList[0].toString()+"마리를 살렸어요"
                        home_comment_air.text="공기"+UrthResultHomeDataList[1].toString()+"L를 깨끗하게 하고"
                        home_comment_tree.text="나무"+UrthResultHomeDataList[2].toString()+"그루를 살리고"
                        home_comment_water.text="깨끗한 물"+UrthResultHomeDataList[3].toString()+"L를 아끼고"
                        home_comment_animal.text="동물"+UrthResultHomeDataList[4].toString()+"마리와 함께하며"


                    }
                }
                }

        })


    }
    fun getHomehallengeDataList(){
        val getPostMyFavoriteChallengeHomeResponse=networkService.getPostMyFavoriteChallengeResponse("application/json",SharedPreferenceControler.getUseToken(context!!))
        getPostMyFavoriteChallengeHomeResponse.enqueue(object :Callback<PostMyFavoriteChallengeHomeResponse>{
            override fun onFailure(call: Call<PostMyFavoriteChallengeHomeResponse>, t: Throwable) {
                Log.e("error","onfailur error")
            }

            override fun onResponse(
                call: Call<PostMyFavoriteChallengeHomeResponse>,
                response: Response<PostMyFavoriteChallengeHomeResponse>
            ) {
                if(response.isSuccessful)
                {
                    if (response.body()!!.status==200)
                    {   Log.v("eeeeee","통신성공")
                        var newDataList:ArrayList<HomechallengeData> = ArrayList<HomechallengeData>()
                            //response.body()!!.data!!
                            //arrayListOf(HomechallengeData("",1,""))
                       // newDataList.addAll(response.body()!!.data!!)
                        newDataList.add(HomechallengeData("",-1,""))
                        newDataList.addAll(response.body()!!.data)
                        newDataList.add(HomechallengeData("",-1,""))


                        challengeRecyclerViewMainAdapter.dataList.clear()
                        challengeRecyclerViewMainAdapter.dataList.addAll(newDataList)
                        challengeRecyclerViewMainAdapter.notifyDataSetChanged()
                    }
                }
                }

        })

    }
//    fun getChallengeDataList(){
//        val getPostMyChallengeTodayResponse=networkService.getPostMyChallengeTodayResponse("application/json",SharedPreferenceControler.getUseToken(context!!))
//        getPostMyChallengeTodayResponse.enqueue(object : Callback<PostMyChallengeDetailResponse>{
//            override fun onFailure(call: Call<PostMyChallengeDetailResponse>, t: Throwable) {
//                Log.v("eee","오늘의 챌린지 통신 실패")
//            }
//
//            override fun onResponse(
//                call: Call<PostMyChallengeDetailResponse>,
//                response: Response<PostMyChallengeDetailResponse>
//            ) {
//                if(response.isSuccessful)
//                {
//                    if(response.body()!!.status==200)
//                    {Log.v("eee","오늘의 챌린지 통신 거의 성공")
//                        var newChallengeDataList:ArrayList<MyChallengeData> = ArrayList<MyChallengeData>()
//                        newChallengeDataList.addAll(response.body()!!.data)
//                        rvChallengeAdapter.dataList.clear()
//                        rvChallengeAdapter.dataList.addAll(newChallengeDataList)
//
//
//                    }
//                }
//                 }
//
//        })
//    }


}
