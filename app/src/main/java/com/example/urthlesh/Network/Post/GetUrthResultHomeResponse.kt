package com.example.urthlesh.Network.Post

data class GetUrthResultHomeResponse(
    var status:Int,
    var success:Boolean?,
    var message:String,
    var data:PostResultHomeData?


)