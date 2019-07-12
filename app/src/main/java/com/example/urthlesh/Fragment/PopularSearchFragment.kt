package com.example.urthlesh.Fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.urthlesh.Activity.SearchActivity
import com.example.urthlesh.ChallengeCreate.ActivityCreateContent

import com.example.urthlesh.R
import kotlinx.android.synthetic.main.fragment_popular_search.*

class PopularSearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_search, container, false)


    }




}
