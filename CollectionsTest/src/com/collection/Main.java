package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static List<Pair<Integer, String>> pairList = new ArrayList<Pair<Integer, String>>();

    public static void main(String args[]){
//        pairList.add(new Pair<Integer, String>(4, "four"));
//        pairList.add(new Pair<Integer, String>(1, "one"));
//        pairList.add(new Pair<Integer, String>(5, "five"));
//        pairList.add(new Pair<Integer, String>(3, "three"));
//        pairList.add(new Pair<Integer, String>(2, "two"));
        pairList.add(new Pair<Integer, String>(0, "four"));
        pairList.add(new Pair<Integer, String>(0, "one"));
        pairList.add(new Pair<Integer, String>(0, "five"));
        pairList.add(new Pair<Integer, String>(1, "three"));
        pairList.add(new Pair<Integer, String>(1, "two"));

        Collections.sort(pairList);
        List<String> list = new ArrayList<>();

        /*for (Pair<Integer, String> pp : pairList){
            System.out.println( pp.getLeft() + ".." + pp.getRight() );
        }*/
    }

//    ArrayList<Song> songList = new ArrayList<Song>();
//
//    class ArtistCompare implements Comparator<Song>{
//        public int compare(Song a, Song b){
//            return a.getArtist().compareTo(b.getArtist());
//        }
//    }
//
//    public static void main(String[] args) {
//        new Main().go();
//    }
//
//    public void go(){
//        getSongs();
//        outputSongList();
//
//        Collections.sort(songList, new ArtistCompare());
//        outputSongList();
//    }
//
//    public int getSongs(){
//        try {
//            File songFile       = new File("songs.txt");
//            BufferedReader br   = new BufferedReader(new FileReader(songFile));
//
//            String line = null;
//            while ( ( line=br.readLine()) != null ){
//                addSong(line);
//            }
//            return 1;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public void addSong(String lineToParse){
//        String[] parts = lineToParse.split(";");
//        songList.add( new Song(parts[0],parts[1],parts[2]));
//    }
//
//    private void outputSongList(){
//        for (Song ss : songList){
//            System.out.println(ss.getTitle()+", "+ss.getArtist()+", "+ss.getGenre() );
//        }
//        System.out.println("");
//    }
}