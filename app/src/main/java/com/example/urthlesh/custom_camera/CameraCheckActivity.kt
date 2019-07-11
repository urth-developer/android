package com.example.urthlesh.custom_camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.urthlesh.CustomView.RectangleImageView
import com.example.urthlesh.Mypage.ProfileEditActivity
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.fragment_mypage.*
import org.jetbrains.anko.startActivity

class CameraCheckActivity : AppCompatActivity() {


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 12) {
            if (resultCode == Activity.RESULT_OK) {
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_check)


        val imageView = findViewById<View>(R.id.preview) as RectangleImageView
        imageView.setAspectRatio(intent.getIntExtra("width", 0), intent.getIntExtra("height", 0))


        var myBitmap = BitmapFactory.decodeByteArray(CameraActivity.mBytes, 0, CameraActivity.mBytes!!.size, null)

        val matrix = Matrix()
        matrix.postRotate(90f)

        myBitmap = Bitmap.createBitmap(myBitmap, 0, 0, myBitmap.width, myBitmap.height, matrix, true)

        //imageView.setBackgroundDrawable(new BitmapDrawable(getResources(), myBitmap));
        imageView.background = BitmapDrawable(resources, myBitmap)

        val btn_picture_certificate = findViewById(R.id.btn_picture_certificate) as ImageButton

        btn_picture_certificate.setOnClickListener {
            val intent = Intent(this@CameraCheckActivity, CameraComplement::class.java)
                   startActivityForResult(intent, 12)
        }
//        btn_picture_certificate.setOnClickListener(
//            object : Button.OnClickListener {
//
//                override fun onClick(v: View) {
//                    val intent = Intent(this@CameraCheckActivity, CameraComplement::class.java)
//                    startActivityForResult(intent, 12)
//                }
//            }
//        )


        val btn_picture_cancel = findViewById(R.id.btn_picture_cancel) as ImageButton
        btn_picture_cancel.setOnClickListener {
            val intent = Intent(this@CameraCheckActivity, CameraActivity::class.java)
                   startActivity(intent);
                   setResult(Activity.RESULT_CANCELED)
                    finish()
        }
//            object : Button.OnClickListener {
//                override fun onClick(v: View) {
//                    Intent intent = new Intent(CameraCheckActivity.this, CameraActivity.class);
//                    startActivity(intent);
//                    setResult(Activity.RESULT_CANCELED)
//                    finish()
//                }
//            }
//        )

        val camera_check_back = findViewById(R.id.camera_check_back) as ImageButton
        camera_check_back.setOnClickListener {
            setResult(Activity.RESULT_OK)
                   finish()
        }

//            object : Button.OnClickListener {
//                override fun onClick(v: View) {
//                    setResult(Activity.RESULT_OK)
//                    finish()
//                }
//            }
//        )


    }
}
