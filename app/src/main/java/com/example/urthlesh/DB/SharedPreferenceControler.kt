package com.example.urthlesh.DB

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceControler {
    val MY_ACCOUNT="unique_string"
    fun setUserToken(ctx:Context,u_token:String){
        val preference: SharedPreferences=ctx.getSharedPreferences(MY_ACCOUNT,Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor=preference.edit()
        editor.putString("u_token",u_token)
        editor.commit()
    }
    fun getUseToken(ctx:Context):String{
        val preferences:SharedPreferences=ctx.getSharedPreferences(MY_ACCOUNT,Context.MODE_PRIVATE)
        return preferences.getString("u_token","")

    }
    fun clearUseToken(ctx:Context){
        val preferences:SharedPreferences=ctx.getSharedPreferences(MY_ACCOUNT,Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor=preferences.edit()
        editor.clear()
        editor.commit()
    }
}