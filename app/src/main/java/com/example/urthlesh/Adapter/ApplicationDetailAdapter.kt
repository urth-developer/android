package com.example.urthlesh.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.urthlesh.Data.ApplicationDetailData
import com.example.urthlesh.R


class ApplicationDetailAdapter(val ctx: Context, val dataList:ArrayList<ApplicationDetailData>) : RecyclerView.Adapter<ApplicationDetailAdapter.Holder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType:Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_application_detail,viewGroup,false)
        return Holder(view)
    }

    override fun getItemCount():Int=dataList.size

    override fun onBindViewHolder(holder: Holder, position:Int){
        Glide.with(ctx).load(dataList[position].application_detail_image).into(holder.application_detail_image)
        holder.application_detail_title.text=dataList[position].application_detail_title
        holder.application_detail_date.text=dataList[position].application_detail_date
        Glide.with(ctx).load(dataList[position].application_detail_chalstatus_wait).into(holder.application_detail_chalstatus_wait)

    }

    inner class Holder(itemView:View):RecyclerView.ViewHolder(itemView){
        var application_detail_image=itemView.findViewById(R.id.img_rv_application_detail_image)as ImageView
        var application_detail_title=itemView.findViewById(R.id.txt_rv_application_detail_title)as TextView
        var application_detail_date=itemView.findViewById(R.id.txt_rv_application_detail_date)as TextView
        var application_detail_chalstatus_wait=itemView.findViewById(R.id.rv_application_detail_chalstatus_wait)as ImageView
    }

}