package com.example.urthlesh.Network.Post

import com.example.urthlesh.Data.ChallengeData
import java.security.MessageDigest
import java.sql.ClientInfoStatus

data class GetCategoryChallengeListResponse(
    val status: Int,
    val message: String,
    val data: ArrayList<ChallengeData>?
)