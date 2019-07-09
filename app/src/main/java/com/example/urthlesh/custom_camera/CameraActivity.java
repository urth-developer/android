
package com.example.urthlesh.custom_camera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.urthlesh.R;

public class CameraActivity extends AppCompatActivity {

    public static final int REQUEST_CAMERA_CHECK = 1;
    public static byte[] mBytes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CAMERA_CHECK){
            if(resultCode == RESULT_OK) finish();
        }
    }



}
