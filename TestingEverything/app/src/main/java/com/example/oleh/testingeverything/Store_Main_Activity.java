package com.example.oleh.testingeverything;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import static com.example.oleh.testingeverything.R.id.imageView;

public class Store_Main_Activity extends Activity {
    ImageView imageView;
    static final int CAM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store__main_);

        Button button =(Button) findViewById(R.id.camera123);
        imageView = (ImageView)findViewById(R.id.photo);
        Button button1 =(Button) findViewById(R.id.camera1234);

        button1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                Intent i = new Intent(Store_Main_Activity.this, QRcode.class);

                startActivity(i);


            }

        });

        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent,CAM_REQUEST);


            }

        });


    }

    private File getFile(){

        File folder = new File("sdcard/camera_app");

        if(!folder.exists()){

            folder.mkdir();

        }

        File image_file = new File(folder, "cam_image.jpg");

        return image_file;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        String path = "sdcard/camera_app/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));

    }
}
