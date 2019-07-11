package com.example.urthlesh.Network

import com.example.urthlesh.Network.Post.GetApplyListResponse
import retrofit2.Call
import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import com.example.urthlesh.Network.Post.PostSignupResponse
import retrofit2.http.GET

interface NetworkService {

    @POST("urth/signup")
    fun postSignupResponse(
        @Header("Content-Type") content_type:String,
        @Body() body: JsonObject
    ): Call <PostSignupResponse>

    @GET("/settings/suggestion")
    fun getApplyListResponse(
        @Header("Content_Type")content_type: String,
        @Header("token")token_type: String
    ): Call<GetApplyListResponse>


}