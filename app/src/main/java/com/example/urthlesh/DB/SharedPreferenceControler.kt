package com.example.urthlesh.DB

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceControler {
    val MY_ACCOUNT="unique_string"
    fun setUserID(ctx:Context,u_id:String){
        val preference: SharedPreferences=ctx.getSharedPreferences(MY_ACCOUNT,Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor=preference.edit()
        editor.putString("u_id",u_id)
        editor.commit()
    }
    fun getUseID(ctx:Context):String{
        val preferences:SharedPreferences=ctx.getSharedPreferences(MY_ACCOUNT,Context.MODE_PRIVATE)
        return preferences.getString("u_id","")!!

    }
    fun clearUseID(ctx:Context){
        val preferences:SharedPreferences=ctx.getSharedPreferences(MY_ACCOUNT,Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor=preferences.edit()
        editor.clear()
        editor.commit()
    }
}