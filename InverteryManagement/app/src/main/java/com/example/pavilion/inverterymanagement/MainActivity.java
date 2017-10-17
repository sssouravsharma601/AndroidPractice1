package com.example.pavilion.inverterymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

 Button add,update,delete;
 Spinner spn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add  =(Button) findViewById(R.id.add);
        update=(Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        spn = (Spinner) findViewById(R.id.spn);
        loadSpinner();
    }

    public void loadSpinner()
    {
        DatabaseHandler dh = new DatabaseHandler(getBaseContext());
        List<String> list = dh.getAllItems();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

    }

    public void operation(View view) {
        try {
            switch (view.getId()) {
                case R.id.add:
                    Intent add = new Intent(getBaseContext(), Adding.class);
                    startActivity(add);
                    break;
                case R.id.update:
                    Intent update = new Intent(getBaseContext(), Update.class);
                    startActivity(update);
                    break;
                case R.id.delete:
                    Intent delete = new Intent(getBaseContext(), Delete.class);
                    startActivity(delete);
                    break;

            }
        }catch (Exception e)
        {
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
    }
    }


}
