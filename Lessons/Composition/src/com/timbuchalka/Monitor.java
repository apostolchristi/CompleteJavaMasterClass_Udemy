package com.timbuchalka;

public class Monitor {

    private String model;
    private String manufacture;
    private int size;
    private Resolution nativeResolution; // this is a composition. The resolution class is part of a monitor, but monitor isn't a resolution but has a resolution
    //the Resolution is a component of a monitor, the monitor has a resolution

    public Monitor(String model, String manufacture, int size, Resolution nativeResolution) {
        this.model = model;
        this.manufacture = manufacture;
        this.size = size;
        this.nativeResolution = nativeResolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println("Drawing pixel at " + x + " " + y + " in colour " + color);
    }

    public String getModel() {
        return model;
    }

    public String getManufacture() {
        return manufacture;
    }

    public int getSize() {
        return size;
    }

    public Resolution getNativeResolution() {
        return nativeResolution;
    }
}
