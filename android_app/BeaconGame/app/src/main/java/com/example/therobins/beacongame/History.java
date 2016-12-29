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

        if(MainActivity.position != 0){
            levels = new String[MainActivity.position];
            for(int x=0; x < MainActivity.position; x++){
                levels[x] = MainActivity.hints.get(x).getText_hint();
            }
        }

        listView = (ListView)findViewById(R.id.history_listView);
        CustomList adapter = new CustomList(this, levels);
        listView.setAdapter(adapter);
    }
}
