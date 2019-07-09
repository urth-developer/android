package com.example.urthlesh.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.example.urthlesh.R
import kotlinx.android.synthetic.main.fragment_advertise.*

class AdvertiseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_advertise, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        val img_url: String = arguments!!.getString("background_url")
       Log.d("url",img_url);
       Glide.with(this)
           .load(img_url)
           .into(img_fragment_advertise)
    }

}
