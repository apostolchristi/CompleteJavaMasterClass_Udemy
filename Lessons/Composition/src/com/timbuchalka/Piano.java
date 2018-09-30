package com.timbuchalka;

public class Piano {

    private String color;
    private String model;
    private int clape;
    private boolean play;

    public Piano(String color, String model, int clape, boolean play) {
        this.color = color;
        this.model = model;
        this.clape = clape;
        this.play = play;
    }

    public void playClassical(String song, int year) {
        System.out.println("playClassical called(): Now is Playing " + song + " from " + year + " year.");
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public int getClape() {
        return clape;
    }

    public boolean isPlay() {
        return play;
    }
}
