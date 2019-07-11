package com.example.urthlesh.Adapter


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.urthlesh.Fragment.FriendUsurthFragment
import com.example.urthlesh.Fragment.MeUsurthFragment
import com.example.urthlesh.Fragment.UsurthFragment

class UsurthAdapter( fm : FragmentManager, private val num_fragment: Int): FragmentStatePagerAdapter(fm){
    companion object  {
        private var meUsurthFragment : MeUsurthFragment? = null
        private var friendUsurthFragment : FriendUsurthFragment? = null

        @Synchronized
        fun getMeUsurthFragment(): MeUsurthFragment{
            if(meUsurthFragment == null) meUsurthFragment =MeUsurthFragment()
            return meUsurthFragment!!
        }
        @Synchronized
        fun getFriendUsurthFragment(): FriendUsurthFragment{
            if(friendUsurthFragment == null) friendUsurthFragment = FriendUsurthFragment()
            return friendUsurthFragment!!
        }
    }

    override fun getItem(p0: Int): Fragment? {
        return when(p0){
            0 -> getMeUsurthFragment()
            1 -> getFriendUsurthFragment()
            else -> null
        }
    }

    override fun getCount(): Int {
        return num_fragment
    }
}

