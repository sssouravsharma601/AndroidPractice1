package com.example.pavilion.inverterymanagement;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Pavilion on 11-05-2016.
 */
public class Update extends Activity
{
    Spinner sp;
    Button Qp,Qs,Pp,Ps,submit;
    TextView Q,P;
    DatabaseHandler dh;
     List list;
    static String priceUP,QunUP;
    static int NmaeCL;
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.update_item);
            sp = (Spinner) findViewById(R.id.updatespn);
            Qp = (Button) findViewById(R.id.Qp);
            Qs = (Button) findViewById(R.id.Qs);
            Pp = (Button) findViewById(R.id.Pp);
            Ps = (Button) findViewById(R.id.Ps);
            Q = (TextView) findViewById(R.id.qun);
            P = (TextView) findViewById(R.id.price);
            dh = new DatabaseHandler(getBaseContext());
            submit =(Button) findViewById(R.id.submit);

            list = dh.getAllItems();
            ArrayAdapter adb = new ArrayAdapter(getBaseContext(), android.R.layout.simple_spinner_item, list);
            adb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp.setAdapter(adb);

            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    String resourcr = "" + String.valueOf(sp.getItemAtPosition(position));

                    List list2 = dh.getItemsPrice(resourcr);

                    NmaeCL =Integer.parseInt(list2.get(0).toString());
                    Q.setText("" + list2.get(1));

                    P.setText("" + list2.get(2));

                    QunUP =Q.getText().toString();
                    priceUP =P.getText().toString();

                             Qp.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {

                                     double QP = Double.parseDouble(Q.getText().toString());


                                     Q.setText(Double.toString(QP + 1));

                                     QunUP = Q.getText().toString();

                                 }
                             });

                    Qs.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            double QP = Double.parseDouble(Q.getText().toString());

                            Q.setText(Double.toString(QP - 1));

                            QunUP = Q.getText().toString();

                        }
                    });

                    Pp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            double pp = Double.parseDouble(P.getText().toString());

                            P.setText(Double.toString(pp + 1));

                            priceUP = P.getText().toString();
                        }
                    });

                    Ps.setOnClickListener(new View.OnClickListener() {


                        @Override
                        public void onClick(View v) {

                            double pp = Double.parseDouble(P.getText().toString());

                            P.setText(Double.toString(pp - 1));
                            priceUP = P.getText().toString();
                        }
                    });

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        double QN = Double.parseDouble(QunUP);
                        double PN = Double.parseDouble(priceUP);
                        int mm = NmaeCL;
                           dh.valueSaved(QN,PN,NmaeCL);

                        Toast.makeText(getBaseContext(), " " +QN + " " + PN + " " + mm, Toast.LENGTH_LONG).show();

                    }catch (Exception e){
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }
            });

        }catch (Exception e)
        {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
