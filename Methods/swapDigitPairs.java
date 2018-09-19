//Swaping digits with places i mean: if input is 4534 - output will be 5434
    public static int swapDigitPairs(int number) {
        int result = 0;
        int place = 1;
        while (number > 9) {
            result += place * 10 * (number % 10);
            number /= 10;
            result += place * (number % 10);
            number /= 10;
            place *= 100;
        }
        System.out.println(result + place * number);
        return result + place * number;
    }