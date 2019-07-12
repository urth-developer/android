package com.example.urthlesh.Adapter

import android.content.Context
import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.urthlesh.Data.ApplyListData
import com.example.urthlesh.R

class ApplyListAdapter(val ctx: Context, val dataList: ArrayList<ApplyListData>) :
    RecyclerView.Adapter<ApplyListAdapter.Holder>() {

    var applyList: ArrayList<ApplyListData> = ArrayList()
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_application_detail, viewGroup, false)

        applyList = dataList
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx).load(applyList[position].image).into(holder.image)
        holder.name.text = applyList[position].name
        holder.createTime.text = applyList[position].createTime

        if (applyList[position].progressStatus == 2)
        // holder.status에 승인 이미지 그리기
            holder.progressStatus.setImageResource(R.drawable.img_chalstatus_accept)
        else if (applyList[position].progressStatus == 0)
            holder.progressStatus.setImageResource(R.drawable.img_chalstatus_wait)
        else if (applyList[position].progressStatus == 1)
            holder.progressStatus.setImageResource(R.drawable.img_chalstatus_fail)
    }


inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var image = itemView.findViewById(R.id.img_rv_application_detail_image) as ImageView
    var name = itemView.findViewById(R.id.txt_rv_application_detail_title) as TextView
    var createTime = itemView.findViewById(R.id.txt_rv_application_detail_date) as TextView
    var progressStatus = itemView.findViewById(R.id.rv_application_detail_imagebutton) as ImageView

}

}