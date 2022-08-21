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

        List<List<Integer>> tripletsList = searchTripletsNaiveApproach(arr);
        System.out.println(tripletsList);
    }


    public static List<List<Integer>> searchTripletsNaiveApproach(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(arr);

        int length = arr.length;

        for (int i = 0; i < length -2 ; i++) {

            for (int j = i+1; j < length - 1; j++) {

                while(arr[i] == arr[j]){
                    ++j;
                }

                for (int k = j+1; k < length; k++) {

                    while(arr[j] == arr[k]){
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

}
