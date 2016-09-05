package com.example.sagar.demolibrary.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sagar.demolibrary.R;
import com.example.sagar.demolibrary.activities.utils.Appconfig;


public class nitialActivity extends AppCompatActivity {

    private TextView textViewMessage;
    private Button btnStartSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nitial);


        textViewMessage = (TextView) findViewById(R.id.textViewMessage);


        btnStartSecond = (Button) findViewById(R.id.btnStartSecond);
        btnStartSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGetMessage = new Intent(nitialActivity.this, SecondActivity.class);
                startActivityForResult(intentGetMessage, Appconfig.RequestCode.REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Appconfig.RequestCode.REQUEST_CODE) {
            if (resultCode == Appconfig.ResultCode.RESULT_OK) {
                if (null != data) {
                    // fetch the message String
                    String message = data.getStringExtra("MESSAGE");
                    textViewMessage.setText("Message from second Activity: " + message);
                }
            } else if (resultCode == Appconfig.ResultCode.RESULT_CANCEL) {
                Toast.makeText(nitialActivity.this, "cancel result from gradle or jar", Toast.LENGTH_LONG).show();
                textViewMessage.setText("Cancelled");
            }
        }
    }
}
