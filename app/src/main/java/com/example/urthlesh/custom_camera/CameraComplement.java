package com.example.urthlesh.custom_camera;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.urthlesh.R;

public class CameraComplement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_success);

        ImageButton profile_edit_back = (ImageButton) findViewById(R.id.profile_edit_back);
        profile_edit_back.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        setResult(RESULT_OK);
                        finish();
                    }
                }
        );


    }
}
