package com.example.sagar.demolibrary.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.sagar.demolibrary.R;
import com.example.sagar.demolibrary.activities.utils.Appconfig;

public class FourthActivity extends AppCompatActivity {

    private EditText editTextMessage;
Button btnStartFourth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        editTextMessage=(EditText)findViewById(R.id.editTextMessage);
    }

    public void submitMessage(View V)
    {
        String message=editTextMessage.getText().toString();
        Intent myIntent = new Intent (FourthActivity.this, nitialActivity.class);
        myIntent.putExtra("MESSAGE", message);
        setResult(Appconfig.ResultCode.RESULT_OK, myIntent);
        finish();
    }

    public void cancelProcedure(View V)
    {
        Intent myIntent = new Intent (FourthActivity.this, nitialActivity.class);
        setResult(Appconfig.ResultCode.RESULT_CANCEL, myIntent);
        finish();
    }
}
