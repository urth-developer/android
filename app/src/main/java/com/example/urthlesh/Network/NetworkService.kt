package com.example.urthlesh.Network

import com.example.urthlesh.Network.Post.*
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    @POST("urth/signup")
    fun postSignupResponse(
        @Header("Content-Type") content_type:String,
        @Body() body: JsonObject
    ): Call <PostSignupResponse>


    @POST("urth/signin")
    fun postLoginResponse(
        @Header("Content-Type") content_type:String,
        @Body() body:JsonObject
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
        @Header("Content-Type") content_type: String
    ): Call<GetChallengeDetailResponse>

    @GET("/urth/challenge/{search}")
    fun getSearchCallengeResponse(
        @Header("Content-Type") content_type: String
    ): Call<GetSearchChallengeResponse>
}