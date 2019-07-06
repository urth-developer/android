package com.example.urthlesh.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.urthlesh.AllurthFragment
import com.example.urthlesh.HomeFragment
import com.example.urthlesh.MypageFragment
import com.example.urthlesh.UsurthFragment

class ProductMainPagerAdapter(fm: FragmentManager, private val num_fragment:Int): FragmentStatePagerAdapter(fm){
    companion object {
        private  var homeFragment: HomeFragment?=null
        private var allurthFragment: AllurthFragment?=null
        private var usurthFragment: UsurthFragment?=null
        private var mypageFragment: MypageFragment?=null

        @Synchronized
        fun getHomeFragment(): HomeFragment {
            if (homeFragment ==null) homeFragment =
                HomeFragment()
            return homeFragment!!
        }
        @Synchronized
        fun getAllurthFragment(): AllurthFragment {
            if (allurthFragment ==null) allurthFragment =
                AllurthFragment()
            return allurthFragment!!
        }
        @Synchronized
        fun getUsurthFragment(): UsurthFragment {
            if (usurthFragment ==null) usurthFragment =
                UsurthFragment()
            return usurthFragment!!
        }
        @Synchronized
        fun getMypageFragment(): MypageFragment {
            if (mypageFragment ==null) mypageFragment =
                MypageFragment()
            return mypageFragment!!
        }
    }
    override fun getItem(p0: Int): Fragment?{
        return when(p0)
        {
            0-> getHomeFragment()
            1-> getAllurthFragment()
            2-> getUsurthFragment()
            3-> getMypageFragment()
            else->null
        }

    }

    override fun getCount(): Int {
        return num_fragment
    }
}