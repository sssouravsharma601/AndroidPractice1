package ci.gourav.com.list_view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] name={"Gourav","Ashish","Sourav","Chitesh","Ajit","Nitin","Avdesh","Honey","Mani","Preeti","Riya","Tanu","Suman"};

        ListAdapter list = new ArrayAdapter<String>(this,R.layout.row_layout,name);

        ListView view =(ListView)findViewById(R.id.myList);

        view.setAdapter(list);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String item = "you selected "+String.valueOf(adapterView.getItemAtPosition(position));

                Toast.makeText(getBaseContext(),item,Toast.LENGTH_LONG).show();
            }
        });
    }


}