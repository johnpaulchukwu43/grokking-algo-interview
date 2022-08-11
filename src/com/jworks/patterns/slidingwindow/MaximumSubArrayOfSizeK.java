package com.jworks.patterns.slidingwindow;

import java.util.Arrays;

public class MaximumSubArrayOfSizeK {

    /*
    * Question: Given an array, find the average of all sub-arrays of ‘K’ contiguous elements in it.
    *
    * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
     *
     * */

    public static void main(String[] args) {
        int K = 5;
        int [] arr = new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
        double[] result = findAveragesNaiveApproach(K,arr);
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }



    public static double[] findAveragesNaiveApproach(int K, int[] arr) {

        /*
        * A brute-force algorithm will calculate the sum of every 5-element subarray of the given array
        * and divide the sum by ‘5’ to find the average.
        *
        * Since for every element of the input array, we are calculating the sum of its next ‘K’ elements,
        * the time complexity of the above algorithm will be O(N*K). where ‘N’ is the number
        * of elements in the input array.
        * */

        int length = arr.length;

        double[] result = new double[length - K + 1];

        for (int i = 0; i <= length - K; i++) {

            System.out.println("current i ="+ arr[i]);

            double sum = 0;

            for (int j = i; j < i + K; j++) {
                sum  += arr[j];
            }

            result [i] = sum / K;
        }

        return result;
    }


}
