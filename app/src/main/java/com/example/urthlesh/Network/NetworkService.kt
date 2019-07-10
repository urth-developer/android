package com.example.urthlesh.Network

import retrofit2.Call
import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import com.example.urthlesh.Network.Post.PostSignupResponse
interface NetworkService {

    @POST("urth/signup")
    fun postSignupResponse(
        @Header("Content-Type") content_type:String,
        @Body() body: JsonObject
    ): Call <PostSignupResponse>


}