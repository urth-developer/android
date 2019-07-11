package com.example.urthlesh.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.urthlesh.Data.DeepTimeline
import com.example.urthlesh.Data.Timeline
import com.example.urthlesh.R





class DeepTimelineAdapter(val ctx: Context, val dataList: ArrayList<DeepTimeline>): RecyclerView.Adapter<DeepTimelineAdapter.Holder>(){

    var colorList: java.util.ArrayList<Int> = arrayListOf(R.drawable.img_timeline_circle_1,R.drawable.img_timeline_circle_2,
        R.drawable.img_timeline_circle_3,R.drawable.img_timeline_circle_4,R.drawable.img_timeline_circle_5)

    lateinit var deepTimelineAdapter:DeepTimelineAdapter

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DeepTimelineAdapter.Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_my_timeline_deep,  viewGroup, false)

        return Holder(view)


        //rv_my_timeline_deep.adapter = deepRecyclerViewAdapter
    }

    override fun getItemCount(): Int {

        return dataList.size
    }
/*
    fun getAuthCount():Int
        {
            return dataList.size
        }*/

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx)
            .load(dataList[position].myphoto)
            .into(holder.my_photo)
        holder.title.text=dataList[position].title
        holder.circle.setImageResource(colorList[position])





        // var itemCount = deepTimelineAdapter.itemCount
        // var itemCount = DeepCertiList2.itemCount



        /*     var itemCount = deepTimelineAdapter.itemCount
     //        holder.setText(txt_my_num)!! = "총 " + itemCount.toString() + "회 인증"
             holder.txt_my_num!!.text = "총" +itemCount.toString()+"회"
             //txt_my_level.text = "Level   " +Use1.level.toString()
             // com.example.urthlesh.Fragment.itemCount = deepTimelineAdapter.itemCount
     */
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var my_photo = itemView.findViewById(R.id.rv_my_photo) as ImageView
        var title = itemView.findViewById(R.id.txt_challenge_title) as TextView
        var circle = itemView.findViewById(R.id.timeline_circle) as ImageView
    }

}