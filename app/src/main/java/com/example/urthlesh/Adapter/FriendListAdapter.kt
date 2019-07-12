package com.example.urthlesh.Adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.urthlesh.Data.FriendData
import com.example.urthlesh.Network.Post.GetUserDataResponse
import com.example.urthlesh.R


class FriendListAdapter(val ctx: Context, var friendList: ArrayList<GetUserDataResponse>): RecyclerView.Adapter<FriendListAdapter.Holder>(){


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_friendlist,  viewGroup, false)

        return Holder(view)
    }

    override fun getItemCount(): Int = friendList.size



    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx)
            .load(friendList[position].profileImg)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.friendimg)


        holder.friendname.text=friendList[position].nickname
        holder.friendlevel.text= "Level. "+friendList[position].level.toString()
        holder.friendsuccess.text= "총 인증횟수:  " + friendList[position].userSuccessCount.toString() + "회"


    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var friendimg = itemView.findViewById(R.id.img_rv_friend_profile) as ImageView
        var friendname = itemView.findViewById(R.id.txt_rv_friend_name) as TextView
        var friendlevel = itemView.findViewById(R.id.int_rv_friend_level) as TextView
        var friendsuccess = itemView.findViewById(R.id.int_rv_friend_num) as TextView
    }

}