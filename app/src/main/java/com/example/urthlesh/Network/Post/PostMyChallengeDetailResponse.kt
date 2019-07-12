package com.example.urthlesh.Network.Post

import com.example.urthlesh.Activity.MyChallengeDetailActivity
import com.example.urthlesh.Data.MyChallengeData

data class PostMyChallengeDetailResponse(
    var status:Int,
    var success:Boolean,
    var message:String,
    var data:ArrayList<MyChallengeData>

)