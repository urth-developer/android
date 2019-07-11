package com.example.urthlesh.Adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View

class CenterZoomLinearLayoutManager(
    context: Context,
    private val mShrinkDistance: Float = 0.9f,
    val mShrinkAmount: Float = 0.15f
) : LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) {

    override fun onLayoutCompleted(state: RecyclerView.State?) {
        super.onLayoutCompleted(state)
        scaleChildren()
    }

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        return if (orientation == HORIZONTAL) {
            super.scrollHorizontallyBy(dx, recycler, state).also {
                scaleChildren()
                //positionChildren()
            }
        } else {
            0
        }
    }

    private fun scaleChildren() {
        val midpoint = width / 2f
        val d1 = mShrinkDistance * midpoint
        for (i in 0 until childCount) {
            val child = getChildAt(i) as View
            val d = Math.min(d1, Math.abs(midpoint - (getDecoratedRight(child) + getDecoratedLeft(child)) / 2f))
            val scale = 1f - mShrinkAmount * d / d1
            Log.v("hihellohi",i.toString()+" : "+ scale.toString() + " / "+d.toString())
            Log.v("hihellohi","---------------------------")

            child.scaleX = scale
            child.scaleY = scale



        }
    }
    private fun positionChildren(){
        val midpoint = width / 2f
        val d1 = mShrinkDistance * midpoint
        for (i in 0 until childCount) {
            val child = getChildAt(i-1) as View
            val child2 = getChildAt(i+1) as View

            val d = Math.min(d1, Math.abs(midpoint - (getDecoratedRight(child) + getDecoratedLeft(child)) / 2f))
            child.y = child.y - 30
            child2.y = child2.y - 30
//            val scale = 1f - mShrinkAmount * d / d1
//            child.scaleX = scale
//            child.scaleY = scale
        }

    }
}