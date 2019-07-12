package com.example.urthlesh.Adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.urthlesh.Fragment.AdvertiseFragment
import com.example.urthlesh.R

class AdvertiseAdapter(fm: FragmentManager?, val num_fragment: Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment? {
        var advertise: AdvertiseFragment = AdvertiseFragment()
        var bundle: Bundle = Bundle(1)
        when (p0) {

            0 -> bundle.putInt("main_img", R.drawable.img_banner_1)
            1 -> bundle.putInt("main_img", R.drawable.img_banner_2)
            2 -> bundle.putInt("main_img", R.drawable.img_banner_3)
        }
        advertise.arguments = bundle
        return advertise
    }

    override fun getCount(): Int {
        return num_fragment
    }
}
