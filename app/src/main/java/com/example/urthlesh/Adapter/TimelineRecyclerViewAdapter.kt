package com.example.urthlesh.Adapter

import android.content.Context
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.urthlesh.Data.DeepTimeline
import com.example.urthlesh.Data.Timeline
import com.example.urthlesh.Fragment.timelineRecyclerViewAdapter
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.fragment_me_usurth.*



class TimelineRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<Timeline>): RecyclerView.Adapter<TimelineRecyclerViewAdapter.Holder>() {
    lateinit var deepTimelineAdapter : DeepTimelineAdapter
    var adapterArray: ArrayList<Int> = ArrayList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TimelineRecyclerViewAdapter.Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_my_timeline,  viewGroup, false)

        return Holder(view)

        //deepRecyclerViewAdapter = DeepRecyclerViewAdapter(context!!, CertificateList)
        //rv_my_timeline_deep.adapter = deepRecyclerViewAdapter
    }

    override fun getItemCount(): Int {

        return dataList.size
    }
  /*  override fun getItemCount(): Int {
    var cnt: Int = 0
        return dataList.size }
    fun getAuthCount():Int
    {
        for(var cnt: Int=0 ; i < dataList.size ;i++)
        return dataList.size
    }
*/

    override fun onBindViewHolder(holder: TimelineRecyclerViewAdapter.Holder, position: Int) {
        holder.photodate.text=dataList[position].photodate
        deepTimelineAdapter = DeepTimelineAdapter(ctx,dataList[position].list)
        holder.rv_my_timeline_deep.adapter = deepTimelineAdapter

       /* var itemCount = deepTimelineAdapter.itemCount
//        holder.setText(txt_my_num)!! = "총 " + itemCount.toString() + "회 인증"
        holder.txt_my_num!!.text = "총" +itemCount.toString()+"회"
        //txt_my_level.text = "Level   " +Use1.level.toString()
        // com.example.urthlesh.Fragment.itemCount = deepTimelineAdapter.itemCount*/
        var linearLayoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
        linearLayoutManager.isAutoMeasureEnabled
        linearLayoutManager.isMeasurementCacheEnabled = false
        holder.rv_my_timeline_deep.layoutManager = linearLayoutManager

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var photodate = itemView.findViewById(R.id.txt_rv_photo_date) as TextView
        var rv_my_timeline_deep=itemView.findViewById(R.id.rv_my_timeline_deep) as RecyclerView
        //var txt_my_num=itemView.findViewById(R.id.txt_my_num) as? TextView

    }

}
