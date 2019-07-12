package com.example.urthlesh.Fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.urthlesh.Activity.CategoryDetailActivity
import com.example.urthlesh.Activity.SearchActivity
import com.example.urthlesh.Adapter.AdvertiseAdapter
import com.example.urthlesh.Adapter.RVChallengeAdapter
import com.example.urthlesh.ChallengeCreate.ActivityCreateTitle
import com.example.urthlesh.Data.ChallengeData
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.GetTop10ChallengeListResponse
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_category_detail.*
import kotlinx.android.synthetic.main.fragment_allurth.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllurthFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_allurth, container, false)
    }


    lateinit var rvChallengeAdapter: RVChallengeAdapter
    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }
    var top10List: ArrayList<ChallengeData> = ArrayList()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        getTop10ChallengeListResponse()

        val lm = LinearLayoutManager(context!!)
        rv_top10_challenge.layoutManager = lm
        rv_top10_challenge.setHasFixedSize(true)


        configureAdvertiseTab()

        btn_search_allurth.setOnClickListener {
            var searchitent = Intent(activity, SearchActivity::class.java);
            context!!.startActivity(searchitent)
        }

        btn_create.setOnClickListener {
            var createintent = Intent(activity, ActivityCreateTitle::class.java);
            context!!.startActivity(createintent)
        }
        imgcategory1.setOnClickListener {
            var categotyintent = Intent(activity, CategoryDetailActivity::class.java);
            categotyintent.putExtra("title", "일회용품")
            categotyintent.putExtra(
                "main_img",
                R.drawable.img_category_dispoable
            )
            context!!.startActivity(categotyintent)
        }
        imgcategory2.setOnClickListener {
            var categoryintent = Intent(activity, CategoryDetailActivity::class.java);
            categoryintent.putExtra("title", "대기")
            categoryintent.putExtra(
                "main_img",
                R.drawable.img_category_air
            )
            context!!.startActivity(categoryintent)
        }
        imgcategory3.setOnClickListener {
            var categoryintent = Intent(activity, CategoryDetailActivity::class.java);
            categoryintent.putExtra("title", "자원")
            categoryintent.putExtra(
                "main_img",
                R.drawable.img_category_tree
            )
            context!!.startActivity(categoryintent)
        }
        imgcategory4.setOnClickListener {
            var categoryintent = Intent(activity, CategoryDetailActivity::class.java);
            categoryintent.putExtra("title", "수질")
            categoryintent.putExtra(
                "main_img", R.drawable.img_category_water
            )
            context!!.startActivity(categoryintent)
        }
        imgcategory5.setOnClickListener {
            var categoryintent = Intent(activity, CategoryDetailActivity::class.java);
            categoryintent.putExtra("title", "생태계")
            categoryintent.putExtra(
                "main_img",
                R.drawable.img_category_ecology
            )
            context!!.startActivity(categoryintent)
        }

    }


    private fun getTop10ChallengeListResponse() {

        val getTop10ChallengeListResponse = networkService.getTop10ChallengeListResponse(
            "application/json"
        )
        getTop10ChallengeListResponse.enqueue(object : Callback<GetTop10ChallengeListResponse> {
            override fun onFailure(call: Call<GetTop10ChallengeListResponse>, t: Throwable) {
                Log.e("Top10 List Fail", t.toString())
            }

            override fun onResponse(
                call: Call<GetTop10ChallengeListResponse>,
                response: Response<GetTop10ChallengeListResponse>
            ) {
                Log.v("hee1","통신 시작")
                if (response.isSuccessful) {
                    if (response.body()!!.status == 200) {

                        val tmp: ArrayList<ChallengeData> = response.body()!!.data!!
                        top10List = tmp
                        rvChallengeAdapter = RVChallengeAdapter(context!!, top10List)
                        rv_top10_challenge.adapter = rvChallengeAdapter
                        rvChallengeAdapter.notifyDataSetChanged()
                    }
                }
            }

        })
    }

    private fun configureAdvertiseTab() {

        vp_advertise.adapter = AdvertiseAdapter(childFragmentManager, 3)
        vp_advertise.offscreenPageLimit = 2
        tl_advertise_indicator.setupWithViewPager(vp_advertise)


    }
}






