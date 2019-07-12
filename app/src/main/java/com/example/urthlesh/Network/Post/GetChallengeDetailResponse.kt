package com.example.urthlesh.Network.Post

import com.example.urthlesh.Data.ChallengeData

data class GetChallengeDetailResponse (
    val status: Int,
    val sucess: Boolean,
    val message: String,
    val data: ChallengeData
)