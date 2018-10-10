package com.timbuchalka;


import java.util.ArrayList;

class IntClass {

     private int myValue;

     public IntClass(int myValue) {
         this.myValue = myValue;
     }

     public int getMyValue() {
         return myValue;
     }

     public void setMyValue(int myValue) {
         this.myValue = myValue;
     }
 }
public class Main {

    public static void main(String[] args) {

        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("Tim");

//        ArrayList<int> intArrayList = new ArrayList<int>();
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));

        Integer integer = new Integer(54);
        Double doubleValue = new Double(23.2);

//-------------------------------------------------------------------

        //AutoBoxing and Unboxing values to use
        ArrayList<Integer> intArraylist = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            //Auto Boxing
            intArraylist.add(Integer.valueOf(i)); // valueof is taking the value of i as the primitive type and converting automatically in to integer class
        }
        for (int i = 0; i < 10; i++) {
            //UnBoxing
            System.out.println(i + " --> " + intArraylist.get(i).intValue()); // .intvalue is a value thats convert Class(Integer) back to primitive type(int)

        }

        //                or
        //Code will still compile because java is doing it automatically for us

        Integer myIntValue = 56; // Integer.valueOf(56); - AutoBoxing automatically to primitive type
        int myInt = myIntValue; //myIntValue.intValue(); - Unboxing automatically to Class

        //                or
        // making it shorter


        ArrayList<Double> myDoubleValue = new ArrayList<Double>();
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
            myDoubleValue.add(dbl); // autoboxing from primitive type double which is "dbl" to double Clas Double
        }

        for (int i = 0; i < myDoubleValue.size(); i++) {
            double value = myDoubleValue.get(i);// Unboxing from Class Double to primityve type double
            System.out.println(i+ " --> " + value);
        }
    }
}
