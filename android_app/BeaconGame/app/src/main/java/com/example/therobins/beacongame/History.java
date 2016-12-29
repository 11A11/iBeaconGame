package com.example.therobins.beacongame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class History extends AppCompatActivity {

    ListView listView;
    String []levels = new String[]{"Something", "Comes", "Here"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listView = (ListView)findViewById(R.id.history_listView);
        CustomList adapter = new CustomList(this, levels);
        listView.setAdapter(adapter);
    }
}
