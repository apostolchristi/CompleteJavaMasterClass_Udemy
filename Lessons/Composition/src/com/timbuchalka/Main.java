package com.timbuchalka;

public class Main {

    public static void main(String[] args) {


        Dimensions dimensions = new Dimensions(20,20,5);
        Case theCase = new Case("220B","Dell", "240",dimensions);

        Monitor themonitor = new Monitor("27inBased","accer", 27, new Resolution(2540,1440));
        //"new Resolution" = if we will don't need to create a variable, you are not going to use it for eneything else, you only want to pass it to a method

        Motherboard themotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PC thePC = new PC(theCase, themonitor, themotherboard);

        thePC.powerUp();

        Bed theBed = new Bed();
        Lights theLights = new Lights(true, "white", true, 3, new LightBulbSpeaker(true, "red", true, true) );
        Piano thePiano = new Piano("brown","zarea", 34, true);
        MyrRoom theMyRoom = new MyrRoom("random", 1, 2, theBed, theLights, thePiano, thePC);

        theMyRoom.turnLights();

//        thePC.getMonitor().drawPixelAt(1500, 1200, "red");
//        thePC.getMotherboard().loadProgram("Windows 8");
//        thePC.getTheCase().presPowerButton();
    }

    // Create a single room of a house using composition.
    // Think about the things that should be included in the room.
    // Maybe physical parts of the house but furniture as well
    // Add at least one method to access an object via a getter and
    // then that objects public method as you saw in the previous video
    // then add at least one method to hide the object e.g. not using a getter
    // but to access the object used in composition within the main class
    // like you saw in this video.



}

