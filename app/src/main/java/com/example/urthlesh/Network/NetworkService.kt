package com.example.urthlesh.Network

import com.example.urthlesh.Network.Post.GetApplyListResponse
import retrofit2.Call
import com.example.urthlesh.Fragment.UsurthFragment
import com.example.urthlesh.Network.Post.GetUrthResultHomeResponse
import com.example.urthlesh.Network.Post.PostLoginResponse
import com.example.urthlesh.Network.Post.PostMyFavoriteChallengeHomeResponse
import com.example.urthlesh.Network.Post.PostSignupResponse

import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST



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


}