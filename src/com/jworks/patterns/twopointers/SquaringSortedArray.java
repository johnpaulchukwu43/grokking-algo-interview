package com.jworks.patterns.twopointers;

import java.util.Arrays;

public class SquaringSortedArray {

   /*
        Given a sorted array, create a new array containing
        squares of all the numbers of the input array in the sorted order.

        Input: [-2, -1, 0, 2, 3]
        Output: [0, 1, 4, 4, 9]
    */

    public static int[] makeSquaresNaiveApproach(int[] arr) {
        int[] squares = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            squares[i] = arr[i] * arr[i];
        }

        Arrays.sort(squares);
        return squares;
    }

    public static int[] makeSquaresOptimal(int[] arr) {


       /*
            The above algorithm’s time complexity will be O(N)
            as we are iterating the input array only once.

            And Space complexity will also be O(N) ; this space will be used for the output array
        */
        int length = arr.length;
        int[] squares = new int[length];

        int leftPointer = 0;
        int rightPointer = length - 1;

        for (int i = length -1; i >= 0; i--) {

            int currentLeftValue = Math.abs(arr[leftPointer]);
            int currentRightValue = Math.abs(arr[rightPointer]);

            if(currentLeftValue >= currentRightValue){
                squares[i] = currentLeftValue * currentLeftValue;
                leftPointer++;
            }else{
                squares[i] = currentRightValue * currentRightValue;
                rightPointer--;
            }
        }

        return squares;
    }


}
