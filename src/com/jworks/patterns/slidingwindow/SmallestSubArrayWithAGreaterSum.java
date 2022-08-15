package com.jworks.patterns.slidingwindow;


public class SmallestSubArrayWithAGreaterSum {

    /*
    *
    *
     * */

    public static void main(String[] args) {

        int [] arr = new int[] { 2, 1, 5, 2, 3, 2}; //s as 7
        int [] arr2 = new int[] { 2, 1, 5, 2, 8}; // s as 7
        int [] arr3 = new int[] { 3, 4, 1, 1, 6}; // s as 8

        int s = 8;

        int result = findMinSubArrayOptimalApproach(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = findMinSubArrayOptimalApproach(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
        result = findMinSubArrayOptimalApproach(8, new int[] { 2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);
    }

    public static int findMinSubArrayNaiveApproach(int S, int[] arr) {
        // runtime complexity would be: O(I*J) = O(N^2)
        int length = arr.length;
        int lengthOfSmallestSubArray = 0;
        //go through all the elements of arr
        for (int i = 0; i < length; i++) {
            int sum = 0;
            // we used the boolean to mark when the smallest length has been found.
            //No need to continue iteration once a small length whose sum of values is greater than S is found.
            boolean isSmallestFound = false;
            for (int j = i; j < length && !isSmallestFound; j++) {
                // for the current element of i, we keep adding contiguous elements using the J pointer until a
                //small length is reached.
                int currentElementsLength = (j - i ) + 1;

                sum+= arr[ j];

                if(sum >= S) {
                    // The currentElementsLength can have a sum of values greater than S
                    // but we only want to update the lengthOfSmallestSubArray variable when
                    // the currentElementsLength is actually smaller than the lengthOfSmallestSubArray
                    int temp = lengthOfSmallestSubArray;
                    lengthOfSmallestSubArray = currentElementsLength;
                    if(temp != 0 && lengthOfSmallestSubArray > temp){
                        lengthOfSmallestSubArray = temp;
                    }

                    isSmallestFound = true;
                }
            }
        }

        return lengthOfSmallestSubArray;
    }

    private static int findMinSubArrayOptimalApproach(int S, int[] a) {
        /*
        1. First, we will add-up elements from the beginning of the array until their sum becomes greater than or equal to ‘S.’
        2. These elements will constitute our sliding window. We are asked to find the smallest such window having a sum greater than or equal to ‘S.’
         We will remember the length of this window as the smallest window so far.
        3. After this, we will keep adding one element in
        the sliding window (i.e., slide the window ahead) in a stepwise fashion.
        4. In each step, we will also try to shrink the window from the beginning.
        We will shrink the window until the window’s sum is smaller than ‘S’ again.
        This is needed as we intend to find the smallest window. This shrinking will also happen in multiple steps;
        in each step, we will do two things:
            a. Check if the current window length is the smallest so far, and if so, remember its length.
            b.Subtract the first element of the window from the running sum to shrink the sliding window.

       The time complexity of the above algorithm will be O(N).
       The outer for loop runs for all elements, and the inner while loop processes each element only once; therefore,
       the time complexity of the algorithm will be O(N+N),which is asymptotically equivalent to O(N)

        Space Complexity: The algorithm runs in constant space O(1)



        */

        int length = a.length;
        int lengthOfSmallestSubArray = Integer.MAX_VALUE;
        int sum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < length; windowEnd++) {
            sum += a[windowEnd];
            while (sum >= S){
                lengthOfSmallestSubArray = Math.min(lengthOfSmallestSubArray, windowEnd - windowStart + 1);
                sum-= a[windowStart];
                windowStart++;
            }
        }

        return lengthOfSmallestSubArray == Integer.MAX_VALUE ? 0: lengthOfSmallestSubArray;

    }


}
