package com.collection;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/7/14
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Song implements Comparable<Song>{
    private String title     = null;
    private String artist    = null;
    private String genre     = null;

    public int compareTo(Song s){
        return title.compareTo(s.getTitle());
    }
    Song (String name, String singer, String category){
        this.title   = name;
        this.artist  = singer;
        this.genre   = category;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }
}
