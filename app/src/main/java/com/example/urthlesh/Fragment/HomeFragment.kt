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
import com.example.urthlesh.Adapter.ChallengeRecyclerViewMainAdapter
import com.example.urthlesh.Adapter.IndicatorAdapter
import com.example.urthlesh.Adapter.RVChallengeAdapter
import com.example.urthlesh.Data.HomechallengeData
//import com.example.urthlesh.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.rv_item_main_challenge.*
import android.widget.RelativeLayout
import android.R
import com.example.urthlesh.Adapter.CenterZoomLinearLayoutManager


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */

var amIFirst = true
class HomeFragment : Fragment() {
    lateinit var challengeRecyclerViewMainAdapter: ChallengeRecyclerViewMainAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.urthlesh.R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var dataList: ArrayList<HomechallengeData> = ArrayList()


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

        challengeRecyclerViewMainAdapter= ChallengeRecyclerViewMainAdapter(context!!,dataList)
        rv_home_challenge.adapter=challengeRecyclerViewMainAdapter
        rv_home_challenge.layoutManager=CenterZoomLinearLayoutManager(context!!)
        //rv_home_challenge.layoutManager=com.example.urthlesh.TurnLayoutManager(context!!,com.example.urthlesh.TurnLayoutManager.Gravity.START,com.example.urthlesh.TurnLayoutManager.Orientation.HORIZONTAL,1500,300,true)
         val indexAdapter = IndicatorAdapter(context!!, dataList)
        rv_home_dot.adapter=indexAdapter
        rv_home_dot.layoutManager=LinearLayoutManager(context!!,LinearLayout.HORIZONTAL,false)

        val snapHelper=LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_home_challenge)
        rv_home_challenge.onFlingListener=snapHelper



        //rv_home_challenge.scrollToPosition(-1)
        //rv_home_challenge.scrollTo(150,0)

        rv_home_challenge.scrollBy(250,0)

        rv_home_challenge.addOnScrollListener(object:RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int){
                super.onScrollStateChanged(recyclerView, newState)

//                if (amIFirst){
//                    val relativeParams = rv_home_challenge_container.layoutParams as RelativeLayout.LayoutParams
//                    relativeParams.rightMargin = 15
//                    relativeParams.leftMargin = 15
//                    amIFirst = false
//                }

                Log.v("bin123",newState.toString())

                indexAdapter.setItenIndex(
                    (recyclerView.layoutManager as LinearLayoutManager)
                        .findFirstVisibleItemPosition()
                )

//                challengeRecyclerViewMainAdapter.printprint(newState)
//
//                challengeRecyclerViewMainAdapter.notifyDataSetChanged()

            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                challengeRecyclerViewMainAdapter.notifyDataSetChanged()
            }


        }


        )
    }


}
