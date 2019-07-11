package com.example.urthlesh.Network.Post

data class PostLoginResponse(
    var status:Int,
    var success:Boolean?,
    var message:String,
    var data:PostLoginData?

)