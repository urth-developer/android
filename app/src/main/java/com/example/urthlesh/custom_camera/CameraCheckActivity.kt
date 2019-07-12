package com.example.urthlesh.custom_camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.urthlesh.CustomView.RectangleImageView
import com.example.urthlesh.DB.SharedPreferenceControler
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.PostCameraResponse
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_camera_check.*
import kotlinx.android.synthetic.main.activity_search.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody

import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.HTTP
import retrofit2.http.Multipart
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.HttpURLConnection

class CameraCheckActivity : AppCompatActivity() {

    lateinit var myBitmap: Bitmap

    val networkService: NetworkService by lazy {
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

        val btn_picture_certificate = findViewById<View>(R.id.btn_picture_certificate) as ImageButton
        btn_picture_certificate.setOnClickListener {
            //            val intent = Intent(this@CameraCheckActivity, CameraComplement::class.java)
//            startActivity(intent)
            Log.v("jiji", "click!")
            postCameraResponse()
        }


//        val btn_picture_cancel = findViewById<View>(R.id.btn_picture_cancel) as ImageButton
        btn_picture_cancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
//            object : Button.OnClickListener {
//                override fun onClick(v: View) {
//                    //                        Intent intent = new Intent(CameraCheckActivity.this, CameraActivity.class);
//                    //                        startActivity(intent);
//                    setResult(Activity.RESULT_CANCELED)
//                    finish()
//                }
//            }
//        )

//        val camera_check_back = findViewById(R.id.camera_check_back) as ImageButton
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

    private fun postCameraResponse() {
        val token = SharedPreferenceControler.getUseToken(this)
        val challengeIdx = SharedPreferenceControler.getUsrChallengeIdx(this)

        if (token != "") {
            val options = BitmapFactory.Options()
            val byteArrayOutputStream = ByteArrayOutputStream()
            myBitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream)
            Log.v("jiji", byteArrayOutputStream.toString())
            val photoBody = RequestBody.create(MediaType.parse("image/jpg"), byteArrayOutputStream.toByteArray())

            val pictureRb = MultipartBody.Part.createFormData("image", "jisooSin", photoBody)

            Log.v("jiji", token)
            Log.v("jiji", challengeIdx.toString())
            Log.v("jiji", myBitmap.toString())
            Log.v("jiji", photoBody.toString())
            Log.v("jiji", pictureRb.toString())
            val postCameraResponse = networkService.postCameraResponse(token, challengeIdx, pictureRb)

            postCameraResponse.enqueue(object : Callback<PostCameraResponse> {
                override fun onFailure(call: Call<PostCameraResponse>, t: Throwable) {
                    Log.v("jiji", t.toString())
                }

                override fun onResponse(call: Call<PostCameraResponse>, response: Response<PostCameraResponse>) {
                    if (response.isSuccessful) {
                        toast(response.body()!!.message)
                        Log.v("jiji", response.body()!!.message)
                        if (response.body()!!.status == 200) {

                            val intent = Intent(this@CameraCheckActivity, CameraComplement::class.java)
                            startActivity(intent)

                        }
                    }
                }

            })
        }


    }
}
