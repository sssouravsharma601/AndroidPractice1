package com.example.pavilion.animation_moving;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;
import java.util.logging.Handler;
public class my_work extends Activity {

    int a =1;
    ImageView box1,box2,line,img1,img2,img3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_work);




        box1 = (ImageView) findViewById(R.id.box1);
        box2 = (ImageView) findViewById(R.id.box2);
        line = (ImageView) findViewById(R.id.line);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);


        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {
                metoo();
                bar();
                onBox2();
                onBox3();
                onBox4();

            }catch (Exception e)
            {
                e.printStackTrace();
            }

            }
        });



    }




    public  void  bar()
    {
        Animation left = AnimationUtils.loadAnimation(getBaseContext(), R.anim.left);
        line.startAnimation(left);
        left.setFillAfter(true);
    }

    public void metoo()
    {
        Animation alpha = AnimationUtils.loadAnimation(getBaseContext(), R.anim.alpha);
        alpha.setRepeatCount(2);
        box2.startAnimation(alpha);

    }

    public void onBox2() {

        try {

            final Animation up = AnimationUtils.loadAnimation(getBaseContext(), R.anim.up);
            img1.setVisibility(View.VISIBLE);
            img1.startAnimation(up);

        }catch (Exception e){

            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }}


    public void onBox3() {

        try {
            final Animation up1 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.up1);
            img2.setVisibility(View.VISIBLE);
            img2.startAnimation(up1);
        }catch (Exception e){

            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }


    public void onBox4() {

        try {
            final Animation up2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.up2);
            img3.setVisibility(View.VISIBLE);
            img3.startAnimation(up2);
        }catch (Exception e){

            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }




    public void onBox1(View view) {
        try {
            Animation right = AnimationUtils.loadAnimation(getBaseContext(), R.anim.right);
            line.startAnimation(right);
            right.setFillAfter(true);

            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img1.setVisibility(View.INVISIBLE);

        }catch (Exception e){

            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

}
