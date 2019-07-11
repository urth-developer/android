package com.example.urthlesh.Network.Post

data class PostLoginData(
    var token:String,
    var userIdx:Int,
    var id:String,
    var nickname:String,
    var level:Int,
    var experiencePoint:Int,
    var profileImg:String

)