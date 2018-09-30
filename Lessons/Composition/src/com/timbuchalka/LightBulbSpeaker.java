package com.timbuchalka;

public class LightBulbSpeaker {

    private boolean on;
    private String color;
    private boolean speaker;
    private boolean timer;

    public LightBulbSpeaker(boolean on, String color, boolean speaker, boolean timer) {
        this.on = on;
        this.color = color;
        this.speaker = speaker;
        this.timer = timer;
    }

    public boolean isOn() {
        return on;
    }

    public String getColor() {
        return color;
    }

    public boolean isSpeaker() {
        return speaker;
    }

    public boolean getTimer() {
        return timer;
    }
}
