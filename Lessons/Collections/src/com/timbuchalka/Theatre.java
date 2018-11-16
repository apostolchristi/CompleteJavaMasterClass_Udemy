package com.timbuchalka;
/*
- Advatages of using Collections is that it permits to use any of its clasess
- ArrayList and LinkedList fit into the COllections framework, and that they can be replaced with other data structures if that structure provides
benefit for a particular task
-Collections class provides a blimey search method that performs much better, as a result we can improve the reserveSeat method and its performance
 */

import java.util.*;

public class Theatre {

    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if(seat1.getPrice() > seat2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    //This constructors takes a theatre name together with the number of rows and the number of seats per row and it uses these to create
    //seats which it currently stores as you can see in the array list on line 9 which is the seats fueled
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        //Theatre seats will be numbered with a row letter an a seat number,
        int lastRow = 'A' + (numRows -1); //Create the last row
        for (char row = 'A'; row <= lastRow; row++) { // cycle through and create a seat for each one of these theater seats or Character increment
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {  // we now need to go through and allocate the seats for that section
                double price = 12.00;

                if((row < 'D') && (seatNum >=4 && seatNum <=9)){
                    price = 14.00;
                }else  if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);//this new Object is collecting what was on previous 3 lines. String.format = make sure they're all allocate with a leading 0 if necessary
                seats.add(seat);//add everything from previous lines to list
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }


    public boolean reserveSeat(String seatNumber) {

        Seat requestedSeat = new Seat(seatNumber, 0); //making a new Seat because we are using comparasion (giving the object for comparason purposes
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if(foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is not seat " + seatNumber);
            return false;
        }
        //Version 0.1 of Sort
//        for (Seat seat : seats) { //parsing list of seats
//            System.out.println(".");
//            if (seat.getSeatNumber().equals(seatNumber)) { //validation if geted seatNumber from the list  == introduced seatNumber
//                requestedSeat = seat; // change the value from null to introduced seat
//                break; //exit
//            }
//        }
//        if (requestedSeat == null) {
//            System.out.println("There is no seat");
//            return false;
//        }
//        return requestedSeat.reserve();
    }
    //We implemented binary search instead of brut sorting
//        int low = 0;
//        int high = seats.size()-1;
//
//        while(low <= high) {
//            System.out.println(".");
//            int mid = (low + high) / 2;
//            Seat midval = seats.get(mid);
//            int cmp = midval.getSeatNumber().compareTo(seatNumber);
//
//            if(cmp < 0) {
//                low = mid + 1;
//            } else if (cmp > 0) {
//                high = mid -1;
//            } else {
//                return seats.get(mid).reserve();
//            }
//        }
//        System.out.println("There is no seat " + seatNumber);
//        return false;
//    }




    //for test
    public Collection<Seat> getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber()); //return the number les than zero, zero with a recall intercoursem a number greater than zero if it's greater than
        }

        public boolean reserve() {
            if (!this.reserved) { //if it's already reserved we're not going to retry and process it and
                this.reserved = true; // if that's the case we were able to reserve it
                System.out.println("Seats " + seatNumber + " reserved");
                return true;
            } else {
                return false; // is already reserved
            }
        }

        //Cancel Function
        public boolean cancel() {
            if (this.reserved) { //if stop reserved and we put if stop reserve
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " canceled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }


        public double getPrice() {
            return price;
        }
    }
}