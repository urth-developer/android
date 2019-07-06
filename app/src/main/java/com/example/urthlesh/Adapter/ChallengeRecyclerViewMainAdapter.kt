package com.example.urthlesh.Adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.urthlesh.Data.HomechallengeData



class ChallengeRecyclerViewMainAdapter(val ctx:Context,val dataList:ArrayList<HomechallengeData>):RecyclerView.Adapter<ChallengeRecyclerViewMainAdapter.Holder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View =
            LayoutInflater.from(ctx).inflate(com.example.urthlesh.R.layout.rv_item_main_challenge, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int){
    Glide.with(ctx)
    .load(dataList[position].img_url)
    .apply(RequestOptions.circleCropTransform())
    .into(holder.img_thumbnail)


    holder.title.text = dataList[position].title
    if (position == 0 || position == dataList.size - 1)
    {

        val params: RecyclerView.LayoutParams = (holder.container).layoutParams as RecyclerView.LayoutParams
        params.leftMargin = 0
        params.rightMargin = 0
        holder.container.setLayoutParams(params)}


        if (position == 1) {
            val params: RecyclerView.LayoutParams = (holder.container).layoutParams as RecyclerView.LayoutParams
            params.leftMargin = 10

            holder.container.setLayoutParams(params)
        }


        if (position == dataList.size - 2) {
            val params: RecyclerView.LayoutParams = (holder.container).layoutParams as RecyclerView.LayoutParams
            params.rightMargin = 20

            holder.container.setLayoutParams(params)

        }
    }

        inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val container =
                itemView.findViewById(com.example.urthlesh.R.id.rv_home_challenge_container) as RelativeLayout
            var img_thumbnail =
                itemView.findViewById(com.example.urthlesh.R.id.img_rv_item_main_thumbnail) as ImageView
            var title = itemView.findViewById(com.example.urthlesh.R.id.txt_rv_item_main_title) as TextView
        }

}
