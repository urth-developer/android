package com.example.urthlesh.ChallengeCreate

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.urthlesh.R
import kotlinx.android.synthetic.main.activity_create_category.*
import kotlinx.android.synthetic.main.activity_create_title.*

class ActivityCreateCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_category)

        btn_back_cteate_category.setOnClickListener{
            setResult(Activity.RESULT_OK)
            finish()
        }
        btn_cancel_cteate_category.setOnClickListener {
            setResult(Activity.RESULT_FIRST_USER)
            finish()
        }
        btn_next_cteate_category.setOnClickListener{
            val createnextcontent = Intent(this, ActivityCreateContent::class.java);
            startActivityForResult(createnextcontent, 127)
        }

        img_category1.setOnClickListener {
            txt_categorytitle.setText("Category Title 1")
            txt_categorycontent.setText("육지에는 환경미화원이 있지만, 바닷속에는 청소부가 없습니다. Wn 우리나라의 플라스틱 사용률이 세계에서 두 번째로 높다는 사실, 알고 계셨나요? 우리는 하루에도 수십 번씩 플라스틱 제품을 사용하고 쉽게 버리곤 합니다. 버려진 플라스틱은 바다로 흘러들어가 바다거북 수명의 네 배가 넘는 시간 동안 썩지 않고 바다 위를 떠다니게 됩니다. 우리의 아름다운 세 바다가 쓰레기로 넘쳐나지 않게, 변화를 위한 실천이 필요한 때입니다.")
        }
        img_category2.setOnClickListener {
            txt_categorytitle.setText("Category Title 2")
            txt_categorycontent.setText("지그은 2시5분 전 배가 고픕니다....\n 히원이가 배가 고파서 김치찌개를 시켰다는 사실., 알고 계셨나요? 우리는 하루에도 수십 번씩 플라스틱 제품을 사용하고 쉽게 버리곤 합니다. 버려진 플라스틱은 바다로 흘러들어가 바다거북 수명의 네 배가 넘는 시간 동안 썩지 않고 바다 위를 떠다니게 됩니다. 우리의 아름다운 세 바다가 쓰레기로 넘쳐나지 않게, 변화를 위한 실천이 필요한 때입니다.")
        }
        img_category3.setOnClickListener {
            txt_categorytitle.setText("미도야 보고싶다 3")
            txt_categorycontent.setText("미도는 저의 귀여운 멍뭉이 입니다.\n 우리나라의 플라스틱 사용률이 세계에서 두 번째로 높다는 사실, 알고 계셨나요? 우리는 하루에도 수십 번씩 플라스틱 제품을 사용하고 쉽게 버리곤 합니다. 버려진 플라스틱은 바다로 흘러들어가 바다거북 수명의 네 배가 넘는 시간 동안 썩지 않고 바다 위를 떠다니게 됩니다. 우리의 아름다운 세 바다가 쓰레기로 넘쳐나지 않게, 변화를 위한 실천이 필요한 때입니다.")
        }
        img_category4.setOnClickListener {
            txt_categorytitle.setText("용이도 보고싶다! 4")
            txt_categorycontent.setText("용이는 저의 기염뽀짝 겸둥이랍니다~?\n 우리나라의 플라스틱 사용률이 세계에서 두 번째로 높다는 사실, 알고 계셨나요? 우리는 하루에도 수십 번씩 플라스틱 제품을 사용하고 쉽게 버리곤 합니다. 버려진 플라스틱은 바다로 흘러들어가 바다거북 수명의 네 배가 넘는 시간 동안 썩지 않고 바다 위를 떠다니게 됩니다. 우리의 아름다운 세 바다가 쓰레기로 넘쳐나지 않게, 변화를 위한 실천이 필요한 때입니다.")
        }
        img_category5.setOnClickListener {
            txt_categorytitle.setText("배가 고프다.. 찌개사랑사랑")
            txt_categorycontent.setText("용이 미도 최고띠~, 바닷속에는 청소부가 없습니다\n우리나라의 플라스틱 사용률이 세계에서 두 번째로 높다는 사실, 알고 계셨나요? 우리는 하루에도 수십 번씩 플라스틱 제품을 사용하고 쉽게 버리곤 합니다. 버려진 플라스틱은 바다로 흘러들어가 바다거북 수명의 네 배가 넘는 시간 동안 썩지 않고 바다 위를 떠다니게 됩니다. 우리의 아름다운 세 바다가 쓰레기로 넘쳐나지 않게, 변화를 위한 실천이 필요한 때입니다.")
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 127){
            if(resultCode == Activity.RESULT_FIRST_USER){
                finish()
            }
        }
    }
}
