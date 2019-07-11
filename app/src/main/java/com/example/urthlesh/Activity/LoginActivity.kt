package com.example.urthlesh.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.urthlesh.DB.SharedPreferenceControler
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {
    val REQUEST_CODE_LOGIN_ACTIVITY=1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btn_startstartstart.setOnClickListener {
            val login_u_id = edtLoginID.text.toString()
            val login_u_pw: String = edtLoginPW.text.toString()

            postLoginResponse(login_u_id, login_u_pw)
            startActivity<MainActivity>()
        }


        txtLoginSignup.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    fun postLoginResponse(u_id:String,u_pw:String)
    {
        SharedPreferenceControler.setUserToken(this,u_id)

    }
}
