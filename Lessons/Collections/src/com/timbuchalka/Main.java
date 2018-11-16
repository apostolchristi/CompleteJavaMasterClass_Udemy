package com.timbuchalka;

/*
-Method that we use to creaate seat copy and populate it in all the elements on theater.seats is called a "shallow copy". So what that does is
creates an arrayList containg all the elements from the list that were passed to the constructor.
- If we want to introduce are own algoritm, Collections class provides a swap method to swap two elements in a list, So we pass the name on the list and
the index position of the two elements that we wanna swap, And what happens is the swap method swaps their position in a list

 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian", 8, 12); // creating an new Object and initializing constructor

        if (theatre.reserveSeat("D12")) {// the second entry in the arrayList which shuld be seat A02 then
            System.out.println("Please play for D12");
        } else { // we are going back, reserving the seat from the other arrayList which ordinarily if there was distinct and separate versions of the objects that should also work
            System.out.println("Seat already reserved");
        }

        if (theatre.reserveSeat("B13")) {// the second entry in the arrayList which shuld be seat A02 then
            System.out.println("Please play for B13");
        } else { // we are going back, reserving the seat from the other arrayList which ordinarily if there was distinct and separate versions of the objects that should also work
            System.out.println("Seat already reserved");
        }

        if (theatre.reserveSeat("D12")) {// the second entry in the arrayList which shuld be seat A02 then
            System.out.println("Please play for D12");
        } else { // we are going back, reserving the seat from the other arrayList which ordinarily if there was distinct and separate versions of the objects that should also work
            System.out.println("Seat already reserved");
        }
        //Reverse (Shufle mode)
        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        //Sorted seats + prices
        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats()); //we got a copy of elements now
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);


    }

    //We create an Array of seat objects and if we pare in the existing seats from our theater object we're going to get a new list containg all the seats.
    public static void printList (List < Theatre.Seat > list) {
        for (Theatre.Seat seat : list) {
            System.out.println(" " + seat.getSeatNumber() + " $ " + seat.getPrice());
        }
        System.out.println();
        System.out.println("====================================================");
    }
}


//        theatre.getSeats();
//        if(theatre.reserveSeat("H11")){
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sory seat is taken");
//        }
//        if(theatre.reserveSeat("H11")){
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sory seat is taken");
//        }

//        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
//        printList(seatCopy);
//
//        seatCopy.get(1).reserve();//we've used copy of the ArrayList from 3 lines higher



//        /*
//        Collections methods are tested
//         */
//        //reverse or shuffle the list
//        Collections.shuffle(seatCopy);
//        System.out.println("Printing searCopy");
//        printList(seatCopy);
//        System.out.println("Printing theatre.seat");
//        printList(theatre.seats);
//
//        //min and max element from the list
//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//        System.out.println("Min seat number is " + minSeat.getSeatNumber());
//        System.out.println("Max seat number is " + maxSeat.getSeatNumber());
//
//        //We sorted it and we've sent the list to this method to line 45 and we're printing it out
//        sortList(seatCopy);
//        System.out.println("Printing sorted seatCopy");
//        printList(seatCopy);
//
//        //We've allocated the amount of size for the array list but instead we get an error Source destination
//        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
//        Collections.copy(newList, theatre.seats);



//===========================================================================================================================================================
//    //We are using variation of the bubleSort method, we are using nested for loops. I want you yo first notice that the end loop doesn't start
//    //at zero but it actually stats after the current position that the outer loop has reached. So in other words, the inner loop is chaning fewer and
//    //fewer elements each time around.
//    public static void sortList(List<? extends Theatre.Seat> list) {
//        for(int i=0; i<list.size() -1; i++) {
//            for(int j=i+1; j<list.size(); j++) {
//                if(list.get(i).compareTo(list.get(j)) >0) { //using the compareTo method to determine or to get a result in integer but depending whether the entries are less than, the same ,or
//                    Collections.swap(list, i, j);
//                }
//            }
//        }
//    }














