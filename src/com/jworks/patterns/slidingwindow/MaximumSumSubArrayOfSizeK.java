package com.jworks.patterns.slidingwindow;


public class MaximumSumSubArrayOfSizeK {

    /*
    * Question: Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
    *
    *   Input: [2, 1, 5, 1, 3, 2], k=3
        Output: 9
        Explanation: Subarray with maximum sum is [5, 1, 3].
     *
     * */

    public static void main(String[] args) {

        int k = 3;
        int [] arr = new int[] { 2, 3, 4, 1, 5};

        int result = findMaxSumSubArrayOptimalApproach(k, arr);
        System.out.println(result);
    }



    public static int findMaxSumSubArrayBruteForceApproach(int k, int[] arr) {

        /*
        *
        * A basic brute force solution will be to calculate the sum of all ‘k’ sized subarrays
        * of the given array to find the subarray with the highest sum.
        *  We can start from every index of the given array and add the next ‘k’ elements to find the subarray’s sum.
        * The above algorithm’s time complexity will be O(N*K), where ‘N’ is the total number of elements in the given array.
        *
        * */

        int length = arr.length;

        int max = 0;

        for (int i = 0; i < length - k; i++) {

            int currentSubArraySum = 0;

            for (int j = 0; j < k; j++) {

                currentSubArraySum += arr[i + j];
            }

            max = Math.max(currentSubArraySum,max);

        }

        return max;
    }

    public static int findMaxSumSubArrayOptimalApproach(int k, int[] arr) {

    /*  For this, consider each subarray as a Sliding Window of size ‘k.’ To calculate the sum of the next subarray,
        we need to slide the window ahead by one element. So to slide the window forward and
        calculate the sum of the new position of the sliding window, we need to do two things:

        1. Subtract the element going out of the sliding window, i.e., subtract the first element of the window.
        2. Add the new element getting included in the sliding window, i.e., the element coming right after
         the end of the window.

         The time complexity of the above algorithm will be O(N)
         The algorithm runs in constant space 0(1)



    */

        int length = arr.length;
        int max = 0;
        int windowStart = 0;
        int currentSubArraySum = 0;

        for (int currentIteration = 0; currentIteration< length ; currentIteration++) {

            currentSubArraySum += arr[currentIteration];

            if(currentIteration >= k-1){
                max = Math.max(currentSubArraySum,max);
                currentSubArraySum -= arr[windowStart];
                windowStart++;
            }
        }

        return max;
    }


}
