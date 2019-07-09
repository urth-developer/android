package com.example.urthlesh.custom_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.urthlesh.CustomView.RectangleImageView;
import com.example.urthlesh.R;

public class CameraCheckActivity extends AppCompatActivity {


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 12){
            if(resultCode == RESULT_OK) {
                setResult(RESULT_OK);
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_check);



        RectangleImageView imageView = (RectangleImageView) findViewById(R.id.preview);
        imageView.setAspectRatio(getIntent().getIntExtra("width", 0), getIntent().getIntExtra("height", 0));


        Bitmap myBitmap = BitmapFactory.decodeByteArray(CameraActivity.mBytes,0,CameraActivity.mBytes.length,null);

        Matrix matrix = new Matrix();
        matrix.postRotate(90);

        myBitmap=Bitmap.createBitmap(myBitmap, 0, 0, myBitmap.getWidth(),myBitmap.getHeight(), matrix, true);

        //imageView.setBackgroundDrawable(new BitmapDrawable(getResources(), myBitmap));
        imageView.setBackground(new BitmapDrawable(getResources(), myBitmap));

        ImageButton btn_picture_certificate = (ImageButton) findViewById(R.id.btn_picture_certificate);
        btn_picture_certificate.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(CameraCheckActivity.this, CameraComplement.class);
                        startActivityForResult(intent, 12);
                    }
                }
        );


        ImageButton btn_picture_cancel = (ImageButton) findViewById(R.id.btn_picture_cancel);
        btn_picture_cancel.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
//                        Intent intent = new Intent(CameraCheckActivity.this, CameraActivity.class);
//                        startActivity(intent);
                        setResult(RESULT_CANCELED);
                        finish();
                    }
                }
        );

        ImageButton backback = (ImageButton) findViewById(R.id.backback);
        backback.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        setResult(RESULT_OK);
                        finish();
                    }
                }
        );


    }
}
