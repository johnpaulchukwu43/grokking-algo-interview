package com.jworks.patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumtoZero {

    /*
    *
    * Input: [-3, 0, 1, 2, -1, 1, -2]
      Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
      Explanation: There are four unique triplets whose sum is equal to zero.
    * */


    public static void main(String[] args) {

        int [] arr = new int[] { -3, 0, 1, 2, -1, 1, -2};

        List<List<Integer>> tripletsList = searchTripletsOptimalApproach(arr);
        System.out.println(tripletsList);
    }


    public static List<List<Integer>> searchTripletsNaiveApproach(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(arr);

        int length = arr.length;

        for (int i = 0; i < length -2 ; i++) {

            for (int j = i+1; j < length - 1; j++) {

                while(arr[i] == arr[j]){
                    //todo implement proper skipping mechanism
                    ++j;
                }

                for (int k = j+1; k < length; k++) {

                    while(arr[j] == arr[k]){
                        //todo implement proper skipping mechanism
                        ++k;
                    }

                    if(arr[i] + arr[j] + arr[k] == 0){
                        triplets.add(Arrays.asList(arr[i], arr[j],arr[k] ));
                    }
                }

            }

        }
        return triplets;
    }

    public static List<List<Integer>> searchTripletsOptimalApproach(int[] arr) {

       /*
        First, we will sort the array and then iterate through it taking one number at a time.
        Let’s say during our iteration we are at number ‘X’, so we need to find ‘Y’ and ‘Z’ such that X + Y + Z == 0
        At this stage, our problem translates into finding a pair whose sum is equal to “-X”
        (as from the above equation Y + Z == -X).
        */

        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
           //skip duplicate elements
           if( i > 0 && arr[i] == arr[i+1]) continue;

           searchPair(triplets,-arr[i],i+1,arr);


        }

        return triplets;

    }

    private static void searchPair(List<List<Integer>> triplets, int targetSum, int left, int [] arr) {

        int right = arr.length -1;

        while (left < right){

            int currentSum = arr[left] + arr[right];

            if(currentSum == targetSum){// found the triplet
                triplets.add(Arrays.asList(-targetSum,arr[left],arr[right]));
                left++;
                right--;

                while (left < right && arr[left] == arr[left - 1]) left++; // skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1]) right--;// skip same element to avoid duplicate triplets

            }else if(currentSum < targetSum){
                left++; // we need a pair with a bigger sum
            }else{
                right--; // we need a pair with a smaller sum
            }

        }
    }
}
