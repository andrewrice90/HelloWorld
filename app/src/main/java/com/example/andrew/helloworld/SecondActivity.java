package com.example.andrew.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Andrew on 22/02/2015.
 */
public class SecondActivity extends Activity {

    private Button myButton;
    private EditText messageField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myform);

        this.myButton = (Button) this.findViewById(R.id.done_button);
        this.messageField = (EditText) this.findViewById(R.id.editText1);

        this.myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("test", messageField.getText().toString());
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });

    }
}
