package com.example.pavilion.listsong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListOfSongsActivity extends AppCompatActivity
{

    public ArrayList<Song> songsList;
    public ListView lvSongs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_of_song_activity);
            lvSongs = (ListView) findViewById(R.id.lvSongs);
            initializeData();
        }catch (Exception e)
        {
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public void initializeData() {
        try {
            songsList = new ArrayList<Song>();
            songsList.add(new Song("Namma Basava", "Namma Basava", "Nimma Basava", "10:00"));
            songsList.add(new Song("Basava", "NBasava", "NBasava", "1:00"));
            songsList.add(new Song("Neo", "Namma Basava", "Nimma Basava", "10:00"));
            songsList.add(new Song("Huchha Venkat", "Namma Basava", "Nimma Basava", "10:00"));
            songsList.add(new Song("Rehaman", "Namma Basava", "Nimma Basava", "30:00"));
            songsList.add(new Song("A Billion Dreams", "Namma Basava", "Nimma Basava", "60:00"));
            songsList.add(new Song("Namma Basava", "Namma Basava", "Nimma Basava", "90:00"));
        }catch (Exception e)
        {
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        MyAdapter myAdapter = new MyAdapter(getBaseContext(), songsList);
        lvSongs.setAdapter(myAdapter);

    }
}
