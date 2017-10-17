package com.example.pavilion.instagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   static String News = null;
    public void show(View view)
    {
        try {
            switch (view.getId()) {
                case R.id.btn2:
                    Intent gI = new Intent(getBaseContext(), News_Activity.class);
                    gI.putExtra(News, "Google");
                    startActivity(gI);
                    break;
                case R.id.btn1:
                    Intent fI = new Intent(getBaseContext(), News_Activity.class);
                    fI.putExtra(News, "Felight");
                    startActivity(fI);
                    break;
            }
        }catch (Exception e)
        {
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
