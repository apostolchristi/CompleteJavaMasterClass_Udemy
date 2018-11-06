package com.company;
// Modify the playlist challenge so that the Album class uses an inner class.
// Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
// The inner SongList class will use an ArrayList and will provide a method to add a song.
// It will also provide findSong() methods which will be used by the containing Album class
// to add songs to the playlist.
// Neither the Song class or the Main class should be changed.


import java.util.*;

public class Main {

    private static List<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {
        // write your code here

        Album album = new Album("StormBringer", "Deep Purple");
        album.addSong("Stormbriger", 4.6);
        album.addSong("Love dont mean a thing", 4.22);
        album.addSong("holy man", 4.3);
        album.addSong("hold on ", 5.6);
        album.addSong("lady double dealer", 3.21);
        album.addSong("you cant do it right", 6.23);
        album.addSong("high ball shooter", 4.27);
        album.addSong("the gypsy", 4.2);
        album.addSong("Solier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("i put the the finger on you", 3.25);
        album.addSong("lets go", 3.45);
        album.addSong("inject the venom", 3.33);
        album.addSong("snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D", 5.25);
        album.addSong("breaking the rules", 5.20);
        album.addSong("night of the long knives", 5.12);
        albums.add(album);

        //adding songs to the playlist
        List<Song> playList = new Vector<>();
        albums.get(0).addToPlayList("you cant do it right", playList);
        albums.get(0).addToPlayList("holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList); //does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList); //there is no track 24

        play(playList);
    }

    private static void play(List<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the  playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying  " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reahed end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playling " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " +listIterator.previous());
                        }
                    }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Avvailable actions: \npress ");
        System.out.println(" 0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to reply the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - delete curent song from playlist");
    }

    private static void printList(List<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===================================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());

        }
        System.out.println("===================================");

    }

















}
