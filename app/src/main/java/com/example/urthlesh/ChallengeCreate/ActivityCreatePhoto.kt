package com.example.urthlesh.ChallengeCreate

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_create_content.*
import kotlinx.android.synthetic.main.activity_create_photo.*
import android.Manifest
import android.os.Build.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_category.*
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import java.io.ByteArrayOutputStream


class ActivityCreatePhoto : AppCompatActivity() {
    lateinit var createtitle:String
    lateinit var createcategory:String
    lateinit var createcontent:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_photo)

        createtitle= intent.getStringExtra("createtitle")
        createcategory= intent.getStringExtra("createcategory")
        createcontent= intent.getStringExtra("createcontent")

        btn_back_create_photo.setOnClickListener{
            setResult(Activity.RESULT_OK)
            finish()
        }
        btn_cancel_create_photo.setOnClickListener {
            setResult(Activity.RESULT_FIRST_USER)
            finish()
        }
        btn_next_create_photo.setOnClickListener{
            val createnextphoto = Intent(this, ActivityCreateCheck::class.java);

            createnextphoto.putExtra("createtitle",createtitle)
            createnextphoto.putExtra("createcategory",createcategory)
            createnextphoto.putExtra("createcontent",createcontent)
            val options = BitmapFactory.Options();
            options.inSampleSize = 1
            // val sendBitmap = BitmapFactory.decodeResource(resources,R.drawable.img_bg_create_photo,options)
            val sendBitmap = (img_pick.getDrawable() as BitmapDrawable).getBitmap()
            val resizeBitmap = Bitmap.createScaledBitmap(sendBitmap,256,256,true);
            val stream = ByteArrayOutputStream()
            resizeBitmap .compress(Bitmap.CompressFormat.JPEG, 100, stream)
            val byteArray = stream.toByteArray()
            createnextphoto.putExtra("createphoto", byteArray)
            Log.v("huiwon",resizeBitmap.toString())
            startActivityForResult(createnextphoto, 127)
        }

        img_pick_btn.setOnClickListener {


            //check runtime permission
            if (VERSION.SDK_INT >= VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                } else {
                    //permission already granted
                    pickImageFromGallery();

                }
            } else {
                //system OS is < Marshmallow
                pickImageFromGallery();

            }

        }

    }

    override fun onRestart() {
        super.onRestart()

    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup granted
                    pickImageFromGallery()

                }
                else{
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 127){
            if(resultCode == Activity.RESULT_FIRST_USER){
                finish()
            }
        }
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            img_pick.setImageURI(data?.data)
            if(data != null)
            {
                img_pick_btn.setText("다른 사진 가져오기")
            }
            else
            {
                img_pick_btn.setText("사진 선택하기")
            }
        }
    }

}
