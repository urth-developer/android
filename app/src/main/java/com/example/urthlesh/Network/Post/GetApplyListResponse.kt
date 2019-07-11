package com.example.urthlesh.Network.Post

import com.example.urthlesh.Data.ApplyListData

data class GetApplyListResponse (
    val status:Int,
    val message:String,
    val data:ArrayList<ApplyListData>
)