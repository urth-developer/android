package com.example.urthlesh.Network.Post

import com.example.urthlesh.Data.HomechallengeData

data class PostMyFavoriteChallengeHomeResponse(
    var status:Int,
    var success:Boolean?,
    var message:String,
    var data:ArrayList<HomechallengeData>
)