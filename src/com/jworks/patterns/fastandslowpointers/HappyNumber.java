package com.jworks.patterns.fastandslowpointers;

public class HappyNumber {

    /*
    Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of
     the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’.
     Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
    * */

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }


    public static boolean find(int num) {

        int fastPointer = num, slowPointer = num;
        do {
            slowPointer = findSquareSum(slowPointer);
            fastPointer = findSquareSum(findSquareSum(fastPointer));

        }while (fastPointer!= slowPointer);

        return slowPointer == 1;
    }

    private static int findSquareSum(int num) {
        int digit,sum= 0;
        while(num > 0){
            digit  = num % 10; //get the remainder .i.e. digit at the end
            sum+= digit * digit;
            num = num/10; //get the divisible value
        }
        return sum;
    }
}
