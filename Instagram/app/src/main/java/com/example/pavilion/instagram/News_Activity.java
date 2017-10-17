package com.example.pavilion.instagram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Pavilion on 13-04-2016.
 */
public class News_Activity extends Activity {


    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
        tvResult = (TextView) findViewById(R.id.txt);

        String show = intent.getStringExtra(MainActivity.News);

        tvResult.setText(show +" will be Displayed");

    }
}
