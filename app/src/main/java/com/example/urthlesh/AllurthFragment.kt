package com.example.urthlesh


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.urthlesh.ChallengeCreate.ActivityCreateTitle
import kotlinx.android.synthetic.main.fragment_allurth.*
import java.util.*



/**
 * A simple [Fragment] subclass.
 *
 */
class AllurthFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_allurth, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        btn_create.setOnClickListener{
            var createintent = Intent(activity, ActivityCreateTitle::class.java);
            startActivity(createintent)
        }
        imgcategory1.setOnClickListener{
            Log.v("hee1","hhhhhhhhhh")
            var intent =Intent(activity, CategoryDetailActivity::class.java);
            intent.putExtra("title", "카테고리1")
            startActivity(intent)
        }
        imgcategory2.setOnClickListener{
            var intent = Intent(activity, CategoryDetailActivity::class.java);
            intent.putExtra("title", "카테고리2")
            startActivity(intent)
        }
        imgcategory3.setOnClickListener{
            var intent = Intent(activity, CategoryDetailActivity::class.java);
            intent.putExtra("title", "카테고리3")
            startActivity(intent)
        }
        imgcategory4.setOnClickListener{
            var intent = Intent(activity, CategoryDetailActivity::class.java);
            intent.putExtra("title", "카테고리4")
            startActivity(intent)
        }
        imgcategory5.setOnClickListener{
            var intent = Intent(activity, CategoryDetailActivity::class.java);
            intent.putExtra("title", "카테고리5")
            startActivity(intent)
        }


      }

    }

