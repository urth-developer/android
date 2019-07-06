package com.example.urthlesh.custom_camera;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.jahyunurth.R;

public class CameraComplement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_success);

        ImageButton btn_cancel = (ImageButton) findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        setResult(RESULT_OK);
                        finish();
                    }
                }
        );


    }
}
