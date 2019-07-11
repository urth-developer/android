package com.example.urthlesh.custom_camera

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.urthlesh.R

class CameraComplement : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_success)

        val camera_complement_back = findViewById<View>(R.id.camera_complement_back) as ImageButton
        camera_complement_back.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

//            object : Button.OnClickListener {
//                override fun onClick(v: View) {
//                    setResult(Activity.RESULT_OK)
//                    finish()
//                }
//            }



    }
}
