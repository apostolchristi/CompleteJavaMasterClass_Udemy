//First 2 int are flour boxes: bigCount == 5kg, smallCount == 1. Sum of this both should equal to goal
    public static boolean canPack (int bigCount, int smallCount, int goal){

        int b = bigCount*5;
        int s = smallCount*1;
        int sum = b + s;

        if((b > goal) && (s < b)){
            System.out.println("False : because bigCount is " + b + " but sum is " + goal);
            return false;
        }

        if ((bigCount == -1) && (smallCount == -1) && (goal == -1)){
            System.out.println("False : Negative Number");
            return false;

        }

        if  (sum >= goal){
            System.out.println("True : because sum is " + sum + " but goal is " + goal);
            return true;
        }



        System.out.println("False");
        return true;
        }
    }