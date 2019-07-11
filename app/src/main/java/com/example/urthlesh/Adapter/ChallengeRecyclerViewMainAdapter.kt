package com.example.urthlesh.Adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.urthlesh.Data.HomechallengeData
import android.view.animation.Animation
import android.view.animation.ScaleAnimation


class ChallengeRecyclerViewMainAdapter(val ctx:Context,val dataList:ArrayList<HomechallengeData>):RecyclerView.Adapter<ChallengeRecyclerViewMainAdapter.Holder>() {
    var lastPosition=-1

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
    .load(dataList[position].image)
    .apply(RequestOptions.circleCropTransform())
    .into(holder.img_thumbnail)

        Log.v("jangyoungbamggukhyom",position.toString())


    holder.title.text = dataList[position].name


        val totalItems = itemCount
        val view = holder.itemView


//
//        val adapterPosition = holder.adapterPosition
//
//        if (position == adapterPosition) {
//            holder.itemView.animate().scaleX(1.5f)
//            holder.itemView.animate().scaleY(1.5f)
//        }


       // setAnimation(holder.itemView,position)

/*  if (position == 0 )
    {

        val params: RecyclerView.LayoutParams = (holder.container).layoutParams as RecyclerView.LayoutParams
        params.leftMargin=-15



        holder.container.setLayoutParams(params)}


        if (position == 1) {
            val params: RecyclerView.LayoutParams = (holder.container).layoutParams as RecyclerView.LayoutParams
            params.leftMargin = 20

            holder.container.setLayoutParams(params)
        }


        if (position == dataList.size - 2) {
            val params: RecyclerView.LayoutParams = (holder.container).layoutParams as RecyclerView.LayoutParams
            params.rightMargin = 20

            holder.container.setLayoutParams(params)

        }*/
    }

        inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val container =
                itemView.findViewById(com.example.urthlesh.R.id.rv_home_challenge_container) as RelativeLayout
            var img_thumbnail =
                itemView.findViewById(com.example.urthlesh.R.id.img_rv_item_main_thumbnail) as ImageView
            var title = itemView.findViewById(com.example.urthlesh.R.id.txt_rv_item_main_title) as TextView
        }

    fun printprint(state: Int){
        Log.v("beom","im scrollllllll >>>  " + state.toString())

    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        // If the bound view wasn't previously displayed on screen, it's animated

        Log.v("hello","positon:"+position.toString())
        if (position > lastPosition) {
            val anim = ScaleAnimation(
                0.0f,
                1.0f,
                0.0f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            anim.duration = 2//Random().nextInt(501)//to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim)
            lastPosition = position
        }
    }

}
