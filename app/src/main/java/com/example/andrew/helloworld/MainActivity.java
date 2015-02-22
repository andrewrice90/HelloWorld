package com.example.andrew.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends ActionBarActivity {

    private static final int MESSAGE_REQUEST= 1;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = (Button) this.findViewById(R.id.go_button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, MESSAGE_REQUEST);
            }
        });
        this.nextButton = (Button) this.findViewById(R.id.next_button);
        this.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImplicitIntentActivity.class);
                startActivity(intent);

            }
        });

        Button viewOnMapButton = (Button) this.findViewById(R.id.viewonmap_button);

        viewOnMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoURIString = "geo:0,0?g=1600+Pennsylvania+Avenue+NW+Washington,+DC+20500";
                Uri geoURI = Uri.parse(geoURIString);
                Intent intent = new Intent(Intent.ACTION_VIEW, geoURI);
                startActivity(intent);
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == MESSAGE_REQUEST){
            String msg = null;
            if(data != null){
                msg = (String) data.getExtras().get("test");
            }
            else{
                msg = "No message received.....";
            }

            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
