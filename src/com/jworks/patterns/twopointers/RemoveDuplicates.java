package com.jworks.patterns.twopointers;

public class RemoveDuplicates {

/*

    Given an array of sorted numbers, remove all duplicate number instances from it in-place, such that each element appears only once.
    The relative order of the elements should be kept the same and you should not use any extra space so that that the solution have a space complexity of O(1).
    Move all the unique elements at the beginning of the array and after moving return the length of the subarray that has no duplicate in it.

    Input: [2, 3, 3, 3, 6, 9, 9]
    Output: 4
    Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
*/


    public static int remove(int[] arr) {

        /*
        * The time complexity of the above algorithm will be O(N),
        * where ‘N’ is the total number of elements in the given array.
        *
        * The algorithm runs in constant space O(1)
        * */


        int currentPointer = 0;


        for (int j = 1;  j < arr.length ; j++) {
            if(arr[currentPointer] != arr[j]){
                ++currentPointer;
                arr[currentPointer] = arr[j];
            }
        }



        //we return + 1 bcos currentPointer started from 0 .i.e array index starts 0
        return currentPointer + 1;
    }

}
