package com.example.urthlesh.Mypage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.urthlesh.Adapter.ApplicationDetailAdapter
import com.example.urthlesh.Data.ApplicationDetailData
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_apply_list.*
import kotlinx.android.synthetic.main.fragment_mypage.*



class ApplyListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_list)

        var dataList: ArrayList<ApplicationDetailData> = ArrayList()
        val applicationDetailAdapter = ApplicationDetailAdapter(this,dataList)
        dataList.add(
            ApplicationDetailData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지이름",
                "20",
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"
            )
        )
        dataList.add(
            ApplicationDetailData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지이름",
                "20",
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"
            )
        )
        dataList.add(
            ApplicationDetailData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지이름",
                "20",
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"
            )
        )
        dataList.add(
            ApplicationDetailData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지이름",
                "20",
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"
            )
        )
        dataList.add(
            ApplicationDetailData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지이름",
                "20",
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"
            )
        )
        dataList.add(
            ApplicationDetailData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지이름",
                "20",
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"
            )
        )
        dataList.add(
            ApplicationDetailData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지이름",
                "20",
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"
            )
        )
        dataList.add(
            ApplicationDetailData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지이름",
                "20",
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"
            )
        )
        dataList.add(
            ApplicationDetailData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지이름",
                "20",
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"
            )
        )
        dataList.add(
            ApplicationDetailData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "챌린지이름",
                "20",
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png"
            )
        )


        rvrv_.adapter = applicationDetailAdapter
        rvrv_.layoutManager = LinearLayoutManager(this)


    }
}
