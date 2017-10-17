package com.example.pavilion.inverterymanagement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Pavilion on 11-05-2016.
 */
public class Adding extends Activity
{
    Button Add;
    EditText Name,Des,Price,quantity;
    Spinner sp;
    String sspp = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding_items);
        Add =(Button)findViewById(R.id.adding);
        Name=(EditText) findViewById(R.id.name);
        Des = (EditText) findViewById(R.id.des);
        quantity = (EditText)findViewById(R.id.Quantity);
        Price = (EditText) findViewById(R.id.price);
        sp = (Spinner)findViewById(R.id.addspn);


        final String[] units ={"Millimetre","Centimeter"," Kilogram","Milligram","Gram","Millilitres"};
        final ArrayAdapter  adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,units);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String uni = "" + String.valueOf(sp.getItemAtPosition(position));
                Toast.makeText(getBaseContext(), uni, Toast.LENGTH_LONG).show();
                sspp = uni;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Add.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {
                String name = Name.getText().toString();
                String desc =Des.getText().toString();
                String myQ = quantity.getText().toString();
                double q =Double.parseDouble(myQ);
                String spp = sspp;
                String price =Price.getText().toString();
                double d = Double.parseDouble(price);
                if(name.trim().length() > 0)
                {
                    DatabaseHandler dbH = new DatabaseHandler(getApplicationContext());
                    dbH.insertItems(name, desc, q,spp, d);


                    InputMethodManager imm =(InputMethodManager)  getSystemService(Context.INPUT_METHOD_SERVICE);
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Please Enter the label Name",Toast.LENGTH_LONG).show();
                }

                Name.setText("");
                Des.setText("");
                Price.setText("");
                Intent in = new Intent(getBaseContext(),MainActivity.class);
                startActivity(in);
            }

        });

    }
}
