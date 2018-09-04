package com.company;

public class Main {

    public static void main(String[] args) {
	 area(5.0);
    }

    public static double area(double radius){

        if (radius < 0){
            return -1.0d;
        }
        double circlearea = radius * radius * 3.1459d;
        return circlearea;
    }

    public static double area(double x, double y){

        if (( x < 0) || (y < 0)){
            return -1.0d;
        }

        double rectanglearea = x * y;
        return rectanglearea;

    }

}
