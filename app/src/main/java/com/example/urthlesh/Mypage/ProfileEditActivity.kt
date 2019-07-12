package com.example.urthlesh.Mypage

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
//import com.example.urthlesh.R

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build.*
//import android.util.Log
//import com.example.urthlesh.Activity.MainActivity
//import com.example.urthlesh.Fragment.MypageFragment
import kotlinx.android.synthetic.main.activity_profile_edit.*
//import kotlinx.android.synthetic.main.activity_profile_edit.edtSignInID
//import kotlinx.android.synthetic.main.activity_profile_edit.edtSignInNickName
//import kotlinx.android.synthetic.main.activity_sign_up.*
//import kotlinx.android.synthetic.main.fragment_mypage.*
import kotlinx.android.synthetic.main.toolbar_profile_edit.*
import org.jetbrains.anko.startActivity
//import android.R
//import android.R
import android.view.View
import android.widget.ImageView
import android.R.drawable
//import android.R
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.ShapeDrawable
//import android.R






class ProfileEditActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.urthlesh.R.layout.activity_profile_edit)

        profile_edit_back.setOnClickListener{
            finish()
        }


        //BUTTON CLICK
        img_pick_btn.setOnClickListener {
            //check runtime permission
            if (VERSION.SDK_INT >= VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                }
                else{
                    //permission already granted
                    pickImageFromGallery();
                }
            }
            else{
                //system OS is < Marshmallow
                pickImageFromGallery();
            }
        }
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


    //handle requested permission result
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

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            image_view.setImageURI(data?.data)
        }
        val imageView = findViewById<View>(com.example.urthlesh.R.id.image_view) as ImageView
        imageView.background = ShapeDrawable(OvalShape())
        imageView.clipToOutline = true

    }


    }



