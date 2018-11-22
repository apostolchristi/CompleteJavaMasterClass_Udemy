package com.timbuchalka;

public class Planet extends HeavenlyBody{

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if(moon.getKey().getBodyType() == BodyTypes.MOON) {
            return super.addSatellite(moon); //performing the add by calling the super which is the add satellite method from HeavenlyBody class
        }
        else {
            return false;
        }
    }
}
