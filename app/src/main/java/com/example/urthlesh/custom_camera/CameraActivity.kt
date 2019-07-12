package com.example.urthlesh.custom_camera

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.urthlesh.R

class CameraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        if (null == savedInstanceState) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, Camera2BasicFragment.newInstance())
                .commit()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

//        var intent:Intent=getIntent()
//        var challengIdx:Int
//            challengIdx=intent.getIntExtra("challengeIdx",0)

        // Shared Preference에 저장


        if (requestCode == REQUEST_CAMERA_CHECK) {
            if (resultCode == Activity.RESULT_OK) finish()
        }
    }

    companion object {

        val REQUEST_CAMERA_CHECK = 1
        var mBytes: ByteArray? = null
    }


}
