package com.jworks.patterns.twopointers;

import java.util.Arrays;

public class SumOfThree {

    /*
    *
    * Given an array of integers, nums, and an integer value, target, determine if there are any three integers
    *  in nums whose sum is equal to the target, that is, nums[i] + nums[j] + nums[k] == target.
    * Return TRUE if three such integers exist in the array. Otherwise, return FALSE.
    *
    *
    * 3,7,1,2,8,4,5
    * 1,2,3,4,5,7,8
    * */

    public static boolean findSumOfThree(int[] nums, int target) {

        Arrays.sort(nums);

        int sum,left,right;


        //we loop till length -2 because we don't want left, right to ever be equals to i
        for (int i = 0; i < nums.length - 2; i++) {

             left = i+1;
             right = nums.length -1;

             while (left < right){
                 sum = nums[i] + nums[left] + nums[right];

                 if(target == sum){
                     return true;
                 }else if(sum < target){
                     left++;
                 }else{
                     right--;
                 }
             }
        }

        return false;
    }
}
