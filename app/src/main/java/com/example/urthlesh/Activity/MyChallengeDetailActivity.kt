package com.example.urthlesh.Activity


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import com.example.urthlesh.Adapter.ItemDragListener
import com.example.urthlesh.Adapter.ItemTouchHelperCallback
import com.example.urthlesh.Adapter.MyChallengeAdapter
import com.example.urthlesh.DB.SharedPreferenceControler
import com.example.urthlesh.Data.MyChallengeData
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.PostMyChallengeDetailResponse
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_mychallengedetail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyChallengeDetailActivity : AppCompatActivity(), ItemDragListener {
    private var items: MutableList<MyChallengeData> = mutableListOf(
        MyChallengeData("챌린지1", "변은빈", 12,"",1),
        MyChallengeData("챌린지2", "라지수", 20,"",1),
        MyChallengeData("챌린지3", "장윤서", 12,"",1),
        MyChallengeData("챌린지4", "신지수", 20,"",1),
        MyChallengeData("챌린지6", "장윤서", 12,"",1),
        MyChallengeData("챌린지6", "신가인", 20,"",1)

    )
    val networkService: NetworkService by lazy{
        ApplicationController.instance.networkService
    }

    private lateinit var myChallengeAdapter: MyChallengeAdapter

    private lateinit var itemTouchHelper: ItemTouchHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mychallengedetail)

        getPostMyChallengeDetailResponse()

        myChallengeAdapter = MyChallengeAdapter(items, this)
        rv_mychallenge.apply {
            adapter = myChallengeAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
        itemTouchHelper= ItemTouchHelper(ItemTouchHelperCallback(myChallengeAdapter))
        itemTouchHelper.attachToRecyclerView(rv_mychallenge)

    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
    }
    fun getPostMyChallengeDetailResponse(){
        val getPostMyChallengeDetailResponse=networkService.getPostMyChallengeDetailResponse("application/json",SharedPreferenceControler.getUseToken(this))
        getPostMyChallengeDetailResponse.enqueue(object : Callback<PostMyChallengeDetailResponse>{
            override fun onFailure(call: Call<PostMyChallengeDetailResponse>, t: Throwable) {
                Log.e("mychallengedetail fail",t.toString())
            }

            override fun onResponse(
                call: Call<PostMyChallengeDetailResponse>,
                response: Response<PostMyChallengeDetailResponse>
            ) {
               if(response.isSuccessful)
               {
                   if(response.body()!!.status==200)
                   {
                       var newitems:MutableList<MyChallengeData> = ArrayList<MyChallengeData>()
                       newitems.addAll(response.body()!!.data)

                       items.clear()
                       items.addAll(newitems)
                       myChallengeAdapter.notifyDataSetChanged()

                   }
               }
            }

        })
    }
}
