package com.timbuchalka;

// Challenge.
// Start with a base class of a Vehicle, then create a Car class that inherits from this base class.
// Finally, create another class, a specific type of Car that inherits from the Car class.
// You should be able to hand steering, changing gears, and moving (speed in other words).
// You will want to decide where to put the appropriate state and behaviours (fields and methods).
// As mentioned above, changing gears, increasing/decreasing speed should be included.
// For you specific type of vehicle you will want to add something specific for that type of car.

public class Tesla extends Car {


    private int roadserviceMonth;

    public Tesla(int roadserviceMonth) {
        super("Tesla", "4WD", 4, 4, 6, false);
        this.roadserviceMonth = roadserviceMonth;
    }

    public void accelerate(int rate) {

        int newVelocity = getCurentVelocity() + rate;
         if (newVelocity == 0) {
             stop();
             changeGhear(1);
         } else if (newVelocity > 0 && newVelocity <= 10) {
             changeGhear(1);
         } else if (newVelocity > 10 && newVelocity <= 20) {
             changeGhear(2);
         } else if (newVelocity > 20 && newVelocity <= 30) {
             changeGhear(3);
         }else {
             changeGhear(4);
         }

         if (newVelocity > 0) {
             changeVelocity(newVelocity, getCurentDirection());
         }
    }
}
