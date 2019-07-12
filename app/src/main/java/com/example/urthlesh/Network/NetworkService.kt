package com.example.urthlesh.Network

import com.example.urthlesh.Network.Post.*
import com.example.urthlesh.Network.Post.GetUserResponse
import com.example.urthlesh.Network.Post.PostLoginResponse
import com.example.urthlesh.Network.Post.PostSignupResponse
import com.google.gson.JsonObject
import com.example.urthlesh.Network.Post.GetApplyListResponse
import retrofit2.Call
import retrofit2.http.*

import com.example.urthlesh.Fragment.UsurthFragment
import com.example.urthlesh.Network.Post.*
import com.example.urthlesh.Network.Post.*

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*


import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface NetworkService {

    @POST("urth/signup")
    fun postSignupResponse(
        @Header("Content-Type") content_type: String,
        @Body() body: JsonObject
    ): Call<PostSignupResponse>

    @POST("urth/signin")
    fun postLoginResponse(
        @Header("Content-Type") content_type: String,
        @Body() body: JsonObject
    ): Call<PostLoginResponse>

    @GET("urth/challenge/summary")
    fun getUrhResultHomeResponse(
        @Header("Content-Type") content_type: String
    ): Call<GetUrthResultHomeResponse>


    @GET("/urth/user/mydata")
    fun getUserResponse(
        @Header("Content-Type") content_type: String,
        @Body() body: JsonObject
    ): Call<PostLoginResponse>

    @GET("/urth/challenge/category/{categoryIdx}")
    fun getCategoryChallengeListResponse(
        @Header("Content-Type") content_type: String,
        @Path("categoryIdx") flag: Int
    ): Call<GetCategoryChallengeListResponse>

    @GET("urth/challenge/top10")
    fun getTop10ChallengeListResponse(
        @Header("Content-Type") content_type: String
    ): Call<GetTop10ChallengeListResponse>

    @GET("/urth/challenge/{challengeIdx}")
    fun getChallengeDetailResponse(
        @Header("Content-Type") content_type: String,
        @Header("token") token: String,
        @Path("challengeIdx") flag:Int
    ): Call<GetChallengeDetailResponse>

    @GET("/urth/challenge/{search}")
    fun getSearchCallengeResponse(
        @Header("Content-Type") content_type: String
    ): Call<GetSearchChallengeResponse>


    @GET("urth/challenge/favorite")
    fun getPostMyFavoriteChallengeResponse(
        @Header("Content-Type") content_type: String,
        @Header("token") token: String
    ): Call<PostMyFavoriteChallengeHomeResponse>


    @GET("/settings/suggestion")
    fun getApplyListResponse(
        @Header("Content_Type") content_type: String,
        @Header("token") token_type: String
    ): Call<GetApplyListResponse>


    @GET("urth/challenge/together")
    fun getPostMyChallengeDetailResponse(
        @Header("Content-Type") content_type: String,
        @Header("token") token: String
    ): Call<PostMyChallengeDetailResponse>


    @Multipart
    @POST("/urth/auth")
    fun postCameraResponse(
        @Header("token") token: String,
        @Part("challengeIdx") challengeIdx: Int,
        @Part cmtImg: MultipartBody.Part

    ): Call<PostCameraResponse>

    @GET("urth/user/friends/list")
    fun getFriendResponse(
        @Header("Content-Type") content_type:String,
        @Header("token")token:String
    ): Call <GetUserResponse>


}