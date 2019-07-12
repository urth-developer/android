package com.example.urthlesh.Network.Post

import com.example.urthlesh.Data.ChallengeData

data class GetSearchChallengeResponse(
    val status: Int,
    val message: String,
    val data: ArrayList<ChallengeData>?
)