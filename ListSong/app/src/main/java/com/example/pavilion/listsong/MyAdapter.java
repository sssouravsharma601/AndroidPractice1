package com.example.pavilion.listsong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter
{

    private Context context;
    private ArrayList<Song> songList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, ArrayList<Song> songList)
    {
        try
        {
            this.context = context;
            this.songList = songList;
            this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public int getCount()
    {
        return songList.size() - 1;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        try
        {
            Song song = songList.get(position);
            convertView = layoutInflater.inflate(R.layout.song_row, parent, false);
            TextView tvSongName = (TextView) convertView.findViewById(R.id.tvSongName);
            TextView tvArtist = (TextView) convertView.findViewById(R.id.tvArtist);
            TextView tvDuration = (TextView) convertView.findViewById(R.id.tvDuration);

            tvSongName.setText(song.getName());
            tvArtist.setText(song.getArtistName());
            tvDuration.setText(song.getDuration());

        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return convertView;
    }

}
