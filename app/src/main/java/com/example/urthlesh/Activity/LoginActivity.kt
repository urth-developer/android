package com.example.urthlesh.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.urthlesh.DB.SharedPreferenceControler
import com.example.urthlesh.Network.ApplicationController
import com.example.urthlesh.Network.NetworkService
import com.example.urthlesh.Network.Post.PostLoginResponse
import com.example.urthlesh.R
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    val REQUEST_CODE_LOGIN_ACTIVITY=1000
    val networkService:NetworkService by lazy{
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLoginSubmit.setOnClickListener {
            val login_u_id = edtLoginID.text.toString()
            val login_u_pw: String = edtLoginPW.text.toString()
            Log.e("loginid",login_u_id)
            Log.e("loginpw",login_u_pw)
            if(isValid(login_u_id,login_u_pw))postLoginResponse(login_u_id,login_u_pw)


        }

        txtLoginSignup.setOnClickListener{
            //회원가입이동
            }
    }
    fun isValid(u_id:String,u_pw:String):Boolean
    {
        if(u_id==""||u_pw=="")
        {
            return false
        }
        return true

    }


    fun postLoginResponse(u_id:String,u_pw:String)
    {
      var jsonObject=JSONObject()
        jsonObject.put("id",u_id)
        jsonObject.put("password",u_pw)

        val gsonObject=JsonParser().parse(jsonObject.toString())as JsonObject
        val postLoginResponse: Call<PostLoginResponse> =
        networkService.postLoginResponse("application/json",gsonObject)
        postLoginResponse.enqueue(object :Callback<PostLoginResponse>{
            override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                Log.e("LOGIN FAILED",t.toString())
            }

            override fun onResponse(call: Call<PostLoginResponse>, response: Response<PostLoginResponse>) {

                if(response.isSuccessful){

                  if(response.body()!!.status==200){

                      SharedPreferenceControler.setUserToken(applicationContext,response.body()!!.data!!.token)
                      startActivity<MainActivity>()
                  }
              }
                 }

        })


    }
}
