    public static int getLargestPrime(int number){

        if (number <= 1){
            System.out.println("Invalid Value");
            return -1;
        }
        for(int i=2; i<number; i++){
            System.out.println("Stept 1: " + number + " and " + i);

            if(number%i == 0){
                System.out.println("Step 2: " + number + " and " + i);

                number /= i;
                System.out.println("Step 3: " + number + " and " + i);

                i--;
                System.out.println("Stept 4: "+ number + " and " + i);

            }
        }
        System.out.println("The prime number is " + number);
        return 1; //number is prime now
    }
}