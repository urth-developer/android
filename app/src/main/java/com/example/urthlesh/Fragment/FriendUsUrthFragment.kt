package com.example.urthlesh.Fragment


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.urthlesh.Activity.AddFriendActivity
import com.example.urthlesh.Adapter.FriendListAdapter
import com.example.urthlesh.Data.FriendData

import com.example.urthlesh.R
import kotlinx.android.synthetic.main.fragment_friend_usurth.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */

lateinit var friendListAdapter: FriendListAdapter

class FriendUsurthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friend_usurth, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_friend_add.setOnClickListener {
            var myintent = Intent(activity, AddFriendActivity::class.java);
            context!!.startActivity(myintent)
        }

        var FriendList: ArrayList<FriendData> = ArrayList()
        FriendList.add(
            FriendData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝둥이", 1
            )
        )
        FriendList.add(
            FriendData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝순이", 2
            )
        )
        FriendList.add(
            FriendData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝솝이", 30
            )
        )
        FriendList.add(
            FriendData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝기요미", 4
            )
        )
        FriendList.add(
            FriendData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "숩둔이", 1
            )
        )
        FriendList.add(
            FriendData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝동이", 2
            )
        )
        FriendList.add(
            FriendData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝둉이", 5
            )
        )
        FriendList.add(
            FriendData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝똥이", 3
            )
        )
        FriendList.add(
            FriendData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝둥이", 7
            )
        )
        FriendList.add(
            FriendData(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png", "솝둥이", 2
            )
        )

        friendListAdapter = FriendListAdapter(context!!, FriendList)
        rv_friend_list.adapter = friendListAdapter
        rv_friend_list.layoutManager = GridLayoutManager(context!!, 2)


        btn_friend_add.setOnClickListener {
            var intentfriend = Intent(activity, AddFriendActivity::class.java);
            context!!.startActivity(intentfriend)
        }

    } }

