package com.example.therobins.beacongame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Rules extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        text1 = (TextView)findViewById(R.id.textView1);
        text1.setText("Rules : \n 1. Something you need to do" + "\n 2. Another rule");
    }
}
