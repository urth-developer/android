package com.example.urthlesh.Network

import com.example.urthlesh.Network.Post.GetUserResponse
import com.example.urthlesh.Network.Post.PostLoginResponse
import com.example.urthlesh.Network.Post.PostSignupResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
interface NetworkService {

    @POST("urth/{signup}")
    fun postSignupResponse(
        @Header("Content-Type") content_type:String,
        @Body() body: JsonObject
    ): Call <PostSignupResponse>


    @POST("urth/{signin}")
    fun postLoginResponse(
        @Header("Content-Type") content_type:String,
        @Body() body:JsonObject
    ): Call<PostLoginResponse>

   @GET("/urth/user/{mydata}")
    fun getUserResponse(
        @Header("Content-Type") content_type:String,
        @Body() body:JsonObject
    ): Call <GetUserResponse>

}