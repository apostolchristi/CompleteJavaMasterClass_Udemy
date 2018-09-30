package com.timbuchalka;

public class Lights {

    private boolean on;
    private String color;
    private boolean lamp;
    private int bulbs;
    private LightBulbSpeaker lightBulbSpeaker;

    public Lights(boolean on, String color, boolean lamp, int bulbs, LightBulbSpeaker lightBulbSpeaker) {
        this.on = on;
        this.color = color;
        this.lamp = lamp;
        this.bulbs = bulbs;
        this.lightBulbSpeaker = lightBulbSpeaker;
    }



    public void lightsManipulation(boolean on){
        this.on = on;
        if (on){
            System.out.println("lightsManipulation called(): Lights are on");
        } else {
            System.out.println("lightsManipulation called(): Lights are off");
        }
    }

    public boolean isOn() {
        return on;
    }

    public String getColor() {
        return color;
    }

    public boolean getLamp() {
        return lamp;
    }

    public int getBulbs() {
        return bulbs;
    }

    public LightBulbSpeaker getLightBulbSpeaker() {
        return lightBulbSpeaker;
    }
}
