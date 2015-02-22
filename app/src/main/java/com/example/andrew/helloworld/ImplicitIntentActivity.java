package com.example.andrew.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

/**
 * Created by Andrew on 22/02/2015.
 */
public class ImplicitIntentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        Button viewImageButton = (Button) this.findViewById(R.id.viewimage_button);
        Button viewImageButton2 = (Button) this.findViewById(R.id.viewimage_button2);

        viewImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                File file = new File("/storage/sdcard0/pictures/image1.jpeg");
                intent.setDataAndType(Uri.fromFile(file), "image/*");
                startActivity(intent);
            }
        });

        viewImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_VIEW);
                File file = new File("/storage/sdcard0/pictures/mhc_1.jpg");
                intent2.setDataAndType(Uri.fromFile(file), "image/*");
                startActivity(intent2);
            }
        });
    }
}
