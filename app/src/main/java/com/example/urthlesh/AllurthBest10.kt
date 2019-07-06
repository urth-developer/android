package com.example.urthlesh


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import com.example.urthlesh.Adapter.RVChallengeAdapter
import com.example.urthlesh.Data.ChallengeData
import kotlinx.android.synthetic.main.fragment_allurth_best10.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AllurthBest10 : Fragment() {

   /* override fun onActivityCreated(savedInstanceState: Bundle?{
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_allurth_best10, container, false)
    }*/

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var dataList: ArrayList<ChallengeData> = ArrayList()
        dataList.add(ChallengeData(
            "nttps://lh3.google.com/u/0/d/160mPDN78IU817UTve2-6hLw2X_2izigu=w1920-h937-iv11",
            "희원이와 함께하는 챌린지","멍뭉최고",127127))

        val rvchallangeAdapter = RVChallengeAdapter(context!!,dataList)
        rv_best10.adapter = rvchallangeAdapter
        rv_best10.layoutManager = LinearLayoutManager(context!!)
    }

}
