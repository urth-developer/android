package com.example.urthlesh.Data

data class ChallengeDetailData(
    var challengeIdx:Int,
    var name:String,
    var explanation:String,
    var category: Int, var image:String ,var count:Int, var creator:String,
                               var totalSuccessCount:Int, var participantCount:Int,var userSuccessCount:Int)