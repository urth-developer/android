package com.example.urthlesh.Activity


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.example.urthlesh.Adapter.ItemDragListener
import com.example.urthlesh.Adapter.ItemTouchHelperCallback
import com.example.urthlesh.Adapter.MyChallengeAdapter
import com.example.urthlesh.Data.MyChallengeData
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_mychallengedetail.*

class MyChallengeDetailActivity : AppCompatActivity(), ItemDragListener {
    private val items: MutableList<MyChallengeData> = mutableListOf(
        MyChallengeData("챌린지1", "변은빈", 12),
        MyChallengeData("챌린지2", "라지수", 20),
        MyChallengeData("챌린지3", "장윤서", 12),
        MyChallengeData("챌린지4", "신지수", 20),
        MyChallengeData("챌린지6", "장윤서", 12),
        MyChallengeData("챌린지6", "신가인", 20)

    )
    private lateinit var myChallengeAdapter: MyChallengeAdapter

    private lateinit var itemTouchHelper: ItemTouchHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mychallengedetail)

        myChallengeAdapter = MyChallengeAdapter(items, this)
        rv_mychallenge.apply {
            adapter = myChallengeAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
        itemTouchHelper= ItemTouchHelper(ItemTouchHelperCallback(myChallengeAdapter))
        itemTouchHelper.attachToRecyclerView(rv_mychallenge)

    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
    }
}
