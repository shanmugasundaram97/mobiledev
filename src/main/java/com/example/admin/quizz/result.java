package com.example.admin.quizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView display=(TextView)findViewById(R.id.display);
        Bundle extra=getIntent().getExtras();
        String result=extra.getString("value");

        display.setText(result);
    }
}
