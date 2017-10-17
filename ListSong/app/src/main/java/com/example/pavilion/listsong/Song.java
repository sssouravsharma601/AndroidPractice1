package com.example.pavilion.listsong;

/**
 * Created by Pavilion on 18-04-2016.
 */
public class Song
{
    private String name;
    private String artistName;
    private String album;
    private String duration;

    public String getName() {
        return name;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbum() {
        return album;
    }

    public String getDuration() {
        return duration;
    }

    public Song(String name, String artistName, String album, String duration) {
        this.duration = duration;
        this.artistName = artistName;
        this.album = album;
        this.name = name;
    }
}
