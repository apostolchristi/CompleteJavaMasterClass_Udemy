//Checking for odd numbers
    public static boolean isOdd(int number) {

        if (number < 0) {
            return false;
        }
        if (number % 2 == 0) {
            //System.out.println("number " +number+" is even ");
            return false;
        }
        //System.out.println("number " +number+" is odd ");
        return true;
    }
//Add sum for odd numbers
    public static int sumOdd(int start, int end) {

        int sum = 0;
        if ((start <= 0) || (end <= 0) || (end < start)) {
            return -1;
        }

        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {
                sum += i;
                System.out.println("Printing nr " + i);
            }
        }


        System.out.println("the sum is " + sum);
        return sum;
    }