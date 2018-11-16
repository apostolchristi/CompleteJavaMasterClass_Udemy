package com.timbuchalka;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        } else {
            this.exits = new HashMap<String, Integer>();
        }
        this.exits.put("Q", 0);
    }

//    public void addExit(String direction, int location) {
//        exits.put(direction,location); //insert in map key and value
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
       /*
       the reason we're doing that is that instead of just returning the exists map We are creating a new HasMap and passing out exits.
       In other words is creating a new map.
       that will be useful technique, cause nothing outside of that class can change exits, so the getter retuns a copy of the exits, so
       if the calling program watns to add or remove mappings from it, then the exits mapping filed won't be affected.
        */
        return new HashMap<String, Integer>(exits);
    }


}
