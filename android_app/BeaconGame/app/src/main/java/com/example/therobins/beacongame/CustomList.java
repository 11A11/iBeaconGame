package com.example.therobins.beacongame;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shikh on 10-12-2016.
 */

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String []s1;

    public CustomList(Activity context, String[]s1)
    {
        super(context, R.layout.list, s1);
        this.context = context;
        this.s1 = s1;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.list, null, true);
            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            TextView txtTitle = (TextView) rowView.findViewById(R.id.history_text1);

            txtTitle.setText(s1[position]);

            return rowView;
    }
}
