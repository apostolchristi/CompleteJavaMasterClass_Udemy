package com.timbuchalka;

// Challenge.
// Start with a base class of a Vehicle, then create a Car class that inherits from this base class.
// Finally, create another class, a specific type of Car that inherits from the Car class.
// You should be able to hand steering, changing gears, and moving (speed in other words).
// You will want to decide where to put the appropriate state and behaviours (fields and methods).
// As mentioned above, changing gears, increasing/decreasing speed should be included.
// For you specific type of vehicle you will want to add something specific for that type of car.

public class Vehicle {

    //adding our new fields for our Class
    private String name;
    private String size;

    private int curentVelocity;
    private int curentDirection;

    //by this we initialize our new object by constructor
    public Vehicle (String name, String size){//constructor parameters
        this.name = name;
        this.size = size;

        this.curentDirection = 0;
        this.curentVelocity = 0;
    }

    public void steering(int direction) {
        this.curentDirection += direction;
        System.out.println("Vehicle steer() : Steering at " + curentDirection + " degrees.");
    }

    public void move(int velocity, int direction) {
        this.curentVelocity = velocity;
        this.curentDirection = direction;
        System.out.println("Vehicle.move(). Move at " + curentVelocity + " in direction "+ curentDirection);
    }

    public void stop () {
        this.curentVelocity = 0;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getCurentVelocity() {
        return curentVelocity;
    }

    public int getCurentDirection() {
        return curentDirection;
    }
}
