package com.example.urthlesh.Activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.PostSignupResponse
import com.example.urthlesh.R
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    val networkService: NetworkService by lazy{
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signup_back.setOnClickListener {
            finish()
        }

        btn_startstart.setOnClickListener {

            val signup_u_id: String=edtSignInID.text.toString()
            val signup_u_name: String=edtSignInNickName.text.toString()
            val signup_u_pw=edtSignIninPW.text.toString()


            Log.v("jiji","hello")

            Log.v("jiji",signup_u_id)
            Log.v("jiji",signup_u_pw)
            Log.v("jiji",signup_u_name)

            Log.v("jiji","bye")

            if (signup_u_id != ""&& signup_u_name != "" && signup_u_pw != "" ){
                  postSignupResponse(signup_u_id,signup_u_name,signup_u_pw)
            }

//            val Intent = Intent(this, MainActivity::class.java)
//            startActivity(Intent)
        }}

        fun postSignupResponse(u_id:String,u_name:String,u_pw:String){

            var jsonObject= JSONObject()
            jsonObject.put("id",u_id)
            jsonObject.put("nickname",u_name)
            jsonObject.put("password",u_pw)

            val gsonObject= JsonParser().parse(jsonObject.toString())as JsonObject
            val postSignupResponse: Call<PostSignupResponse> = networkService.postSignupResponse("application/json",gsonObject)
            postSignupResponse.enqueue(object: Callback<PostSignupResponse>{
                override fun onFailure(call: Call<PostSignupResponse>, t: Throwable) {
                    Log.e("Signup failed",t.toString())
                }

                override fun onResponse(call: Call<PostSignupResponse>, response: Response<PostSignupResponse>) {
                    if(response.isSuccessful){
                        toast(response.body()!!.message)
                        if(response.body()!!.status==200){
//                            val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
//                            val e_time=simpleDateFormat.format(Date())
                                Log.e("Signup success",response.body()!!.message.toString())
                            val intent:Intent=Intent()
//                            intent.putExtra("end_time",e_time)
                            setResult(Activity.RESULT_OK,intent)
                            finish()
                        }
                    }
                }
            })


        }

    }


