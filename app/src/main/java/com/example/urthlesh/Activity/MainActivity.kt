package com.example.urthlesh.Activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.urthlesh.Adapter.ProductMainPagerAdapter
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val permissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA
    )

    private val MULTIPLE_PERMISSIONS = 101

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermissions()

        /*btn_camera.setOnClickListener {
            var intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }*/

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbarVisibility(View.GONE)
        configureMainTab()
    }


    private fun checkPermissions(): Boolean {
        var result: Int
        val permissionList = ArrayList<String>()
        for (pm in permissions) {
            result = ContextCompat.checkSelfPermission(this, pm)
            if (result != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(pm)
            }
        }
        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(this, permissionList.toTypedArray(), MULTIPLE_PERMISSIONS)
            return false
        }
        return true
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MULTIPLE_PERMISSIONS -> {
                if (grantResults.size > 0) {
                    for (i in permissions.indices) {
                        if (permissions[i] == this.permissions[0]) {
                            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                                showNoPermissionToastAndFinish()
                            }
                        } else if (permissions[i] == this.permissions[1]) {
                            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                                showNoPermissionToastAndFinish()

                            }
                        } else if (permissions[i] == this.permissions[2]) {
                            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                                showNoPermissionToastAndFinish()

                            }
                        }
                    }
                } else {
                    showNoPermissionToastAndFinish()
                }
                return
            }
        }
    }


    private fun showNoPermissionToastAndFinish() {
        Toast.makeText(this, "권한 요청에 동의 해주셔야 이용 가능합니다. 설정에서 권한 허용 하시기 바랍니다.", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun configureMainTab()
    {
        vp_main.adapter= ProductMainPagerAdapter(this,supportFragmentManager, 4)
        vp_main.offscreenPageLimit=2
        vp_main.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                if(p0 == 0) setToolbarVisibility(View.GONE)
                else if(p0 == 1) setToolbarVisibility(View.VISIBLE)
                else if(p0 == 2) setToolbarVisibility(View.VISIBLE)
                else if(p0 == 3) setToolbarVisibility(View.VISIBLE)
            }
        })
        tl_main.setupWithViewPager(vp_main)

        val navCategoryMainLayout: View =(this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater)
            .inflate(R.layout.navigation_main,null,false)
        tl_main.getTabAt(0)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_main_home) as RelativeLayout
        tl_main.getTabAt(1)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_main_allurth) as RelativeLayout
        tl_main.getTabAt(2)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_main_usurth) as RelativeLayout
        tl_main.getTabAt(3)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_main_mypage) as RelativeLayout

    }

     fun setToolbarVisibility(visiblitilty:Int){

        toolbar_main.visibility=visiblitilty
    }
}
