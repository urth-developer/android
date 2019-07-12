package com.example.urthlesh.Network.Post

data class GetFriendSearchData (
    var userIdx : Int,
    var nickname : String,
    var level : Int,
    var profileImg : String,
    var friendship : Boolean

)