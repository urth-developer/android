package com.example.urthlesh.Network.Post

data class GetUserResponse (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: GetUserDataResponse?

)

