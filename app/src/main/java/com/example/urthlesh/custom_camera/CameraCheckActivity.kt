package com.example.urthlesh.custom_camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.example.urthlesh.CustomView.RectangleImageView
import com.example.urthlesh.DB.SharedPreferenceControler
import com.example.urthlesh.Mypage.ProfileEditActivity
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.fragment_mypage.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.startActivity
import java.io.ByteArrayOutputStream
import java.io.InputStream

class CameraCheckActivity : AppCompatActivity() {

    lateinit var myBitmap:Bitmap

    val networkService:NetworkService by lazy{
        ApplicationController.instance.networkService
    }


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


        myBitmap = BitmapFactory.decodeByteArray(CameraActivity.mBytes, 0, CameraActivity.mBytes!!.size, null)

        val matrix = Matrix()
        matrix.postRotate(90f)

        myBitmap = Bitmap.createBitmap(myBitmap, 0, 0, myBitmap.width, myBitmap.height, matrix, true)

        //imageView.setBackgroundDrawable(new BitmapDrawable(getResources(), myBitmap));
        imageView.background = BitmapDrawable(resources, myBitmap)

        val btn_picture_certificate = findViewById(R.id.btn_picture_certificate) as ImageButton

        btn_picture_certificate.setOnClickListener {
            val intent = Intent(this@CameraCheckActivity, CameraComplement::class.java)
                   startActivityForResult(intent, 12)

            postCameraResponse()
        }



        val btn_picture_cancel = findViewById(R.id.btn_picture_cancel) as ImageButton
        btn_picture_cancel.setOnClickListener {
            val intent = Intent(this@CameraCheckActivity, CameraActivity::class.java)
                   startActivity(intent);
                   setResult(Activity.RESULT_CANCELED)
                    finish()
        }


        val camera_check_back = findViewById(R.id.camera_check_back) as ImageButton
        camera_check_back.setOnClickListener {
            setResult(Activity.RESULT_OK)
                   finish()
        }

    }


    private fun postCameraResponse(){
        val token = SharedPreferenceControler.getUseToken(this)

        val options = BitmapFactory.Options()
        val byteArrayOutputStream=ByteArrayOutputStream()
        myBitmap.compress(Bitmap.CompressFormat.JPEG,20,byteArrayOutputStream)
        val photoBody = RequestBody.create(MediaType.parse("image/jpg"),byteArrayOutputStream.toByteArray())

        val picture_rb = MultipartBody.Part.createFormData("image","ShinJisoo",photoBody)

        val postCameraRequestBody = networkService.postCameraResponse(token,picture_rb)


    }
}
