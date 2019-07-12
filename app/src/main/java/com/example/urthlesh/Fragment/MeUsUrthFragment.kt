package com.example.urthlesh.Fragment



import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.example.urthlesh.Adapter.TimelineRecyclerViewAdapter
import com.example.urthlesh.Data.DeepTimeline
import com.example.urthlesh.Data.Timeline
import com.example.urthlesh.Data.UserData

import kotlinx.android.synthetic.main.fragment_me_usurth.*
import com.example.urthlesh.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
import kotlinx.android.synthetic.main.fragment_me_usurth.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
public class Square {}
public class MyRender {}



/**
 * A simple [Fragment] subclass.
 *
 */

lateinit var timelineRecyclerViewAdapter: TimelineRecyclerViewAdapter


var itemCount = 0





class MeUsurthFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.example.urthlesh.R.layout.fragment_me_usurth, container, false)}
    //var CircleArray = context?.resources?.obtainTypedArray(R.array.circlelist)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /* 추후 서버와의 통신으로 대체할 부분입니다 */
        var DeepCertiList1: ArrayList<DeepTimeline> = ArrayList()
        DeepCertiList1.add(
            DeepTimeline(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "종이빨대 사용하기"
            )
        )
        DeepCertiList1.add(
            DeepTimeline(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "재활용컵 사용하기"
            )
        )

        var DeepCertiList2: ArrayList<DeepTimeline> = ArrayList()
        DeepCertiList2.add(
            DeepTimeline(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "텀블러 사용하기"
            )
        )
        DeepCertiList2.add(
            DeepTimeline(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "재활용컵 사용하기"
            )
        )
        DeepCertiList2.add(
            DeepTimeline(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "재활용컵 사용하장장장"
            )
        )
        DeepCertiList2.add(
            DeepTimeline(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "텀블러 사용하기"
            )
        )

        var DeepCertiList3: ArrayList<DeepTimeline> = ArrayList()
        DeepCertiList3.add(
            DeepTimeline(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "재활용컵 사용하기"
            )
        )
        DeepCertiList3.add(
            DeepTimeline(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "텀블러 사용하기"
            )
        )
        DeepCertiList3.add(
            DeepTimeline(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "텀블러 사용하기"
            )
        )
        DeepCertiList3.add(
            DeepTimeline(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "텀블러 사용하기"
            )
        )
        DeepCertiList3.add(
            DeepTimeline(
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
                "빈츠 사용하기"
            )
        )

        var CertificateList: ArrayList<Timeline> = ArrayList()
        CertificateList.add(Timeline("6월 12일", DeepCertiList1))
        CertificateList.add(Timeline("6월 15일", DeepCertiList2))
        CertificateList.add(Timeline("6월 17일", DeepCertiList3))

        timelineRecyclerViewAdapter = TimelineRecyclerViewAdapter(context!!, CertificateList)
        rv_my_timeline.adapter = timelineRecyclerViewAdapter
        //itemCount = timelineRecyclerViewAdapter.itemCount
        //itemCount = CertificateList.size
        var linearLayoutManager = LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        linearLayoutManager.isAutoMeasureEnabled = true
        linearLayoutManager.isMeasurementCacheEnabled = false
        rv_my_timeline.layoutManager = linearLayoutManager
        var Use1 = UserData(7)
        txt_my_level.text = "Level   " +Use1.level.toString()

        itemCount =0
        for (item in CertificateList){
            itemCount += item.list.size
        }
        txt_my_num.text = "총 " + itemCount.toString() + "회 인증"



       // chart.setBackgroundColor(Color.rgb(100, 65, 82));

        chart.getDescription().setEnabled(false);

        chart.setWebLineWidth(1f);
        chart.setWebColor(Color.WHITE);
        chart.setWebLineWidthInner(1f);
        chart.setWebColorInner(Color.WHITE);
        chart.setWebAlpha(100);
        // create a custom MarkerView (extend MarkerView) and specify the layout
        // to use for it

        setData();

        chart.animateXY(1400, 1400, Easing.EaseInOutQuad);

        var xAxis: XAxis = chart.getXAxis();
        xAxis.setTextSize(12f);
        xAxis.setYOffset(0f);
        xAxis.setXOffset(0f);
        xAxis.valueFormatter = object: IAxisValueFormatter {

            private val mActivities: Array<String>  = arrayOf("일회용품", "대기", "자원", "수질", "생태계");

            override fun getFormattedValue(value: Float, axis: AxisBase?): String {
                return mActivities[(value % mActivities.size).toInt()] //as Int];
            }

        };
        xAxis.setTextColor(Color.WHITE);


        var yAxis: YAxis = chart.getYAxis();
        yAxis.setLabelCount(5, false);
        yAxis.setTextSize(12f);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(80f);
        yAxis.setDrawLabels(false);

        var l: Legend = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setTextColor(Color.WHITE);
    }

    private fun setData() {

        var mul: Float = 80.0f;
        var min: Float = 0.0f;
        var cnt: Int = 4;

        var entries1: ArrayList<RadarEntry> = ArrayList<RadarEntry>()

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for ( i in 0..cnt) {
            val val1: Float = ((Math.random() * mul) + min).toFloat() //as Float;
            entries1.add(RadarEntry(val1));
        }


        var set1: RadarDataSet = RadarDataSet(entries1, "Last Week");

        set1.setColor(Color.rgb(72,137,140),89)
        set1.setFillColor(Color.rgb(72 ,137,140))
        set1.setDrawFilled(true)
        set1.setFillAlpha(180)
        set1.setLineWidth(1f)
        set1.setDrawHighlightCircleEnabled(true)
        set1.setDrawHighlightIndicators(false)




        var sets: ArrayList<IRadarDataSet> = ArrayList<IRadarDataSet>();
        sets.add(set1);

        var data: RadarData = RadarData(sets);
        data.setValueTextSize(12f);
        data.setDrawValues(false);
        data.setValueTextColor(Color.WHITE);

        chart.setData(data);
        chart.invalidate();
    }
}

