package com.timbuchalka;

// Challenge.
// Start with a base class of a Vehicle, then create a Car class that inherits from this base class.
// Finally, create another class, a specific type of Car that inherits from the Car class.
// You should be able to hand steering, changing gears, and moving (speed in other words).
// You will want to decide where to put the appropriate state and behaviours (fields and methods).
// As mentioned above, changing gears, increasing/decreasing speed should be included.
// For you specific type of vehicle you will want to add something specific for that type of car.

public class Car extends Vehicle {

    private int weels;
    private int doors;
    private int gears;
    private boolean isManual;

    private int curentGear;

    public Car(String name, String size, int weels, int doors, int gears, boolean isManual) {
        super(name, size);
        this.weels = weels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.curentGear = 1;
    }

    public void changeGhear(int curentGear) {
        this.curentGear = curentGear;
        System.out.println("Car.setCurentGear: Changed to "  + this.curentGear + " gear");
    }

    public void changeVelocity(int speed, int direction) {
        System.out.println("Car changeVelocity(): Velocity " + speed + " direction " + direction);
        move(speed, direction);
    }
}


