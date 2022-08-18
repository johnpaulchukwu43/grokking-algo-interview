package com.jworks.patterns.twopointers;

public class PairwithTargetSum {

    /*
    * Given an array of sorted numbers and a target sum,
    * find a pair in the array whose sum is equal to the given target.
    *
    *   Input: [1, 2, 3, 4, 6], target=6
        Output: [1, 3]
        Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
     *
    * */


    public static int[] searchNaiveApproach(int[] arr, int targetSum) {

        int length = arr.length;

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length; j++) {

                if(arr[i] + arr[j] == targetSum){
                    return new int[]{i,j};
                }
            }
        }

        //nothing found
        return new int[]{-1,-1};
    }

    public static int[] searchMoreOptimalApproach(int[] arr, int targetSum) {

        int length = arr.length;

        int leftPointer = 0;
        int rightPointer = length -1;

        for (int i = 0; i < length; i++) {

            int currentLeftValue = arr[leftPointer];
            int currentRightValue = arr[rightPointer];
            int currentSum = currentLeftValue + currentRightValue;

            if(currentSum == targetSum){
                return new int[]{leftPointer,rightPointer};
            }else if (currentSum > targetSum){
                rightPointer-=1;
            }else{
                leftPointer+=1;
            }
        }

        //nothing found
        return new int[]{-1,-1};
    }
}
