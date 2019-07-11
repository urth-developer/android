package com.example.urthlesh.Network

import retrofit2.Call
import com.example.urthlesh.Fragment.UsurthFragment
import com.example.urthlesh.Network.Post.*


import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*


interface NetworkService {
    @POST("urth/signin")
    fun postLoginResponse(
        @Header("Content-Type") content_type:String,
        @Body() body:JsonObject
    ): Call<PostLoginResponse>

    @POST("urth/signup")
    fun postSignupResponse(
        @Header("Content-Type") content_type:String,
        @Body() body: JsonObject
    ): Call <PostSignupResponse>

    @GET("urth/challenge/summary")
    fun getUrhResultHomeResponse(
        @Header("Content-Type") content_type:String
    ):Call<GetUrthResultHomeResponse>

    @GET("urth/challenge/favorite")
    fun getPostMyFavoriteChallengeResponse(
        @Header("Content-Type") content_type:String,
        @Header("token")token:String
    ):Call<PostMyFavoriteChallengeHomeResponse>


    @GET("/settings/suggestion")
    fun getApplyListResponse(
        @Header("Content_Type")content_type: String,
        @Header("token")token_type: String
    ): Call<GetApplyListResponse>


    @Multipart
    @POST("/urth/auth")
    fun postCameraResponse(
        @Header("token") token:String,

        @Part cmtImg:MultipartBody.Part

    ):Call<PostCameraResponse>


}