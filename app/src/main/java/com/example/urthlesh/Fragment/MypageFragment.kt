package com.example.urthlesh.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.urthlesh.Adapter.ApplicationDetailAdapter
import com.example.urthlesh.Mypage.*
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.fragment_mypage.*
import org.jetbrains.anko.startActivity


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MypageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_mypage, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        profile_edit.setOnClickListener {
            context!!.startActivity<ProfileEditActivity>()
        }


        apply_list.setOnClickListener {
            context!!.startActivity<ApplyListActivity>()
        }
        alarm_set.setOnClickListener {
            context!!.startActivity<AlarmActivity>()
        }

        suggest.setOnClickListener {
            context!!.startActivity<SuggestActivity>()
        }

        introduce.setOnClickListener {
            context!!.startActivity<IntroduceServiceActivity>()
        }

        terms.setOnClickListener{
            context!!.startActivity<TermsActivity>()
        }



        }



    }

