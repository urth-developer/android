package com.example.urthlesh.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.urthlesh.Fragment.PopularSearchFragment
import com.example.urthlesh.Fragment.ResultSearchFragment
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_popular_search.*
import kotlinx.android.synthetic.main.toolbar_search.*

class SearchActivity : AppCompatActivity() {
   /* lateinit var btn_search:Button
    lateinit var frag_popular_search:FragmentManager
    lateinit var frag_result_search:FragmentManager*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        supportFragmentManager.beginTransaction().replace(R.id.search_frame, PopularSearchFragment()).commit()
        btn_search.setOnClickListener { supportFragmentManager.beginTransaction().replace(R.id.search_frame, ResultSearchFragment()).commit() }

        //txt_recomend_search1.setOnClickListener{
        //   edit_txt_search.setText(txt_recomend_search1.text)
        // }
    }
}
