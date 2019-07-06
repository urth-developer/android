package com.example.urthlesh.Adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.urthlesh.Data.HomechallengeData
import com.example.urthlesh.R

class IndicatorAdapter(val context: Context,var dataList:ArrayList<HomechallengeData>):
        RecyclerView.Adapter<IndicatorAdapter.IndexListViewHolder>(){
    val indexList=Array(dataList.size){false}
    var index=0

    init{
        if(dataList.size>1)
            indexList[1]=true
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): IndicatorAdapter.IndexListViewHolder {
        val viewGroup=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_circle,parent,false)
        return IndexListViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return dataList.size
      }
    fun setItenIndex(position :Int)
    {
        indexList[index]=false
        indexList[position+1]=true
        index=position+1
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: IndexListViewHolder, position: Int) {
       val asset = context.resources.getDrawable(
           if(position==0||position==dataList.size-1) R.drawable.trans_circle
           else if(indexList[position]) R.drawable.fill_circle
       else R.drawable.stoke_circle
       )
        holder.bind(asset)
        }
    inner class IndexListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val dotsView: View= itemView.findViewById(R.id.img_item_circle) as ImageView

        fun bind(asset:Drawable){
            dotsView.background=asset
        }

    }



}

