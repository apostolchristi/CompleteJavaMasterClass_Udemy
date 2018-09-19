    //Calculating radius
    public static double area(double radius){

        if (radius < 0){
            return -1.0d;
        }
        double circlearea = radius * radius * 3.1459d;
        
        System.out.println(circlearea);
        return circlearea;
    }

    //Calculating area
    public static double area(double x, double y){

        if (( x < 0) || (y < 0)){
            return -1.0d;
        }

        double rectanglearea = x * y;
        
        System.out.println(rectanglearea);
        return rectanglearea;

    }

}