package com.example.urthlesh

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureMainTab()
    }
    private fun configureMainTab()
    {
        vp_main.adapter=ProductMainPagerAdapter(supportFragmentManager,4)
        vp_main.offscreenPageLimit=2
        tl_main.setupWithViewPager(vp_main)

        val navCategoryMainLayout: View =(this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater)
            .inflate(R.layout.navigation_main,null,false)
        tl_main.getTabAt(0)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_main_home) as RelativeLayout
        tl_main.getTabAt(1)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_main_allurth) as RelativeLayout
        tl_main.getTabAt(2)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_main_usurth) as RelativeLayout
        tl_main.getTabAt(3)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_main_mypage) as RelativeLayout

    }
}
