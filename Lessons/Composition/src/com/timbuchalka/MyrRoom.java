package com.timbuchalka;

public class MyrRoom {

    private String book;
    private int carpet;
    private int armChar;
    private Bed bed;
    private Lights lights;
    private Piano piano;
    private PC pc;

    public MyrRoom(String book, int carpet, int armChar, Bed bed, Lights lights, Piano piano, PC pc) {
        this.book = book;
        this.carpet = carpet;
        this.armChar = armChar;
        this.bed = bed;
        this.lights = lights;
        this.piano = piano;
        this.pc = pc;
    }

    public void turnLights() {
        lights.lightsManipulation(true);
    }

    private void playSong() {
        piano.playClassical("Moon Sonata", 1801);
    }

    public Piano getPiano() {
        return piano;
    }

    public String getBook() {
        return book;
    }

    public int getCarpet() {
        return carpet;
    }

    public int getArmChar() {
        return armChar;
    }

    public Bed getBed() {
        return bed;
    }

    public Lights getLights() {
        return lights;
    }

    public PC getPc() {
        return pc;
    }
}
