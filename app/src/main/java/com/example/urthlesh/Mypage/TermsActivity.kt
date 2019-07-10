package com.example.urthlesh.Mypage

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.urthlesh.Fragment.MypageFragment
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.toolbar_terms.*
import org.jetbrains.anko.startActivity

class TermsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)

        terms_back.setOnClickListener{
            finish()
        }
    }


}
