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
        text1.setText("Rules/Format : \n 1. 5 beacons have been placed around the campus\n" +
                "\n 2. When you reach at a beacon, the hint would be played on your phone\n" +
                "\n 3. Use this hint to get to the next level, where you would encounter another beacon\n"
        + "\n 4. You can access the hints at any level if and only if all the previous levels have been unlocked\n");
    }
}
