package com.example.urthlesh.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.urthlesh.Data.ChallengeComment
import com.example.urthlesh.R

class CommentAdapter(val ctx: Context, val dataList:ArrayList<ChallengeComment>):RecyclerView.Adapter<CommentAdapter.Holder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view:View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_comment,viewGroup,false)
        return Holder(view)
    }

    override fun getItemCount(): Int =dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int){
        Glide.with(ctx).load(dataList[position].profileimg).into(holder.profileimage)
        holder.nickname.text=dataList[position].nickname
        holder.comment.text=dataList[position].comment
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var profileimage = itemView.findViewById(R.id.img_profile_comment) as ImageView
        var nickname = itemView.findViewById(R.id.txt_nickname_comment) as TextView
        var comment = itemView.findViewById(R.id.txt_comment_comment) as TextView
    }
}
