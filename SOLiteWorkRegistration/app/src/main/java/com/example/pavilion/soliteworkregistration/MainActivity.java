package com.example.pavilion.soliteworkregistration;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity  {

    EditText Name ;
    EditText City;
    EditText State;
    Button b1,b2;
    private   DbAdapter dbAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Name = (EditText) findViewById(R.id.name);
            City = (EditText) findViewById(R.id.city);
            State = (EditText) findViewById(R.id.state);
            b1=(Button)findViewById(R.id.submit);
            b1=(Button)findViewById(R.id.Show);
            dbAdapter = new DbAdapter(this);

        }catch (Exception e){
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
    }

    public void Saving(View view)
    {
        try {
            String N = Name.getText().toString();
            String C = City.getText().toString();
            String S = State.getText().toString();
            dbAdapter.open();
            boolean r = dbAdapter.contacts(N, C, S);
            Toast.makeText(this, " " + r, Toast.LENGTH_SHORT).show();
            dbAdapter.close();


        }catch (Exception e)
        {
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();

        }
    }

    public  void Show(View view)
    {
        try {
            dbAdapter.open();

            Cursor cursor = dbAdapter.getAllContacts();
            cursor.moveToFirst();
            do {
                String row = cursor.getString(0) + "  " + cursor.getString(1) + "  " + cursor.getString(2) ;
                Toast.makeText(getBaseContext(), row, Toast.LENGTH_LONG).show();
            } while (cursor.moveToNext());
            dbAdapter.close();
        }catch (Exception e){

            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
