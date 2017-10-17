package com.example.pavilion.inverterymanagement;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Pavilion on 11-05-2016.
 */
public class Delete extends Activity {


    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.delete_item);
            listView = (ListView) findViewById(R.id.lv);
            DatabaseHandler dh = new DatabaseHandler(getBaseContext());
            List data  = dh.getAllItems();
            final ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,data);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String select = String.valueOf(parent.getItemAtPosition(position));                }
            });


        }catch (Exception e)
        {
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
