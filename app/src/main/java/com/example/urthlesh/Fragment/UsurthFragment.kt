package com.example.urthlesh.Fragment


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.urthlesh.Adapter.UsurthAdapter
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.fragment_usurth.*

import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"





class UsurthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_usurth, container, false)


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        configureUsTab()
    }

    private fun configureUsTab(){
        vp_usurth.adapter = UsurthAdapter(childFragmentManager, 2)
        vp_usurth.offscreenPageLimit=1
        us_earth_me_friend.setupWithViewPager(vp_usurth)

        val navUsurthLayout: View = (context!!.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater)
            .inflate(R.layout.navigation_usurth,null,false)
        us_earth_me_friend.getTabAt(0)!!.customView = navUsurthLayout.findViewById(R.id.navigation_all_urth_me) as RelativeLayout
        us_earth_me_friend.getTabAt(1)!!.customView = navUsurthLayout.findViewById(R.id.navigation_all_urth_friend) as RelativeLayout




    }
}

