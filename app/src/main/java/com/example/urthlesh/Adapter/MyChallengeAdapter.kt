package com.example.urthlesh.Adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.urthlesh.Data.MyChallengeData
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.item_mychallenge.view.*

class MyChallengeAdapter(
    private val dataList: MutableList<MyChallengeData>,
    private val listener: ItemDragListener
) : RecyclerView.Adapter<MyChallengeAdapter.ViewHolder>(), ItemActionListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_mychallenge, parent, false)


        return ViewHolder(view, listener)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun onItemMoved(from: Int, to: Int) {
        if (from == to) {
            return
        }

        val fromItem = dataList.removeAt(from)
        dataList.add(to, fromItem)
        notifyItemMoved(from, to)
    }

    override fun onItemSwiped(position: Int) {
        dataList.removeAt(position)
        notifyItemRemoved(position)
    }

    class ViewHolder(itemView: View, listener: ItemDragListener) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.drag_handle.setOnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    listener.onStartDrag(this)
                }
                false
            }
        }

        fun bind(item: MyChallengeData) {
            itemView.rv_item_mychallenge_title.text = item.title
            itemView.rv_item_mychallenge_creator.text = item.creator
            itemView.rv_item_mychallenge_numofchallenge.text = "총"+item.numofchallenge.toString()+"회"
        }
    }
}