package com.jworks.patterns.slidingwindow;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKMaximumDistinctCharacters {

    /*
    *
    * Question: Given a string, find the length of the longest substring in it with no more than K distinct characters.
    * Input: String="araaci", K=2
       Output: 4
       Explanation: The longest substring with no more than '2' distinct characters is "araa".
     * */

    public static void main(String[] args) {

        String str = "cbbebi";
        int k = 3;

        int length = findLengthNaiveApproach(str, k);
        System.out.println(length);
    }


    public static int findLengthNaiveApproach(String str, int k) {

        /*
        *
        * Approach:
        * initialize the lengthOfLongestSubstringWithNoMoreThanKCharacters LSWK var as 0
        * 1. loop through each char C of Str S
        * 2. for each char C, we create all possible contiguous substrings
        * 3. Now for any contiguous substring created we check if it has no more than K distinct characters
        *       i . if it does, we check the length of the substring against LSWK.
        *           a. if it is longer than LSWK then we asign the value as LSWK
        *
        * 4. Runtime: O(N^3) omo !!!! not advisable :/
        * */


        int length = str.length();

        int lengthOfLongestSubstringWithNoMoreThanKCharacters = 0;

        for (int i = 0; i <  length; i++) {
            for (int j =  i; j < length; j++) {

                String currentSubstring = str.substring(i, j);
                boolean hasDistinctChar = hasMoreDistinctCharThanK(currentSubstring,k);
                if(!hasDistinctChar){
                    lengthOfLongestSubstringWithNoMoreThanKCharacters =
                            Math.max(lengthOfLongestSubstringWithNoMoreThanKCharacters,currentSubstring.length());
                }

            }
        }


        return lengthOfLongestSubstringWithNoMoreThanKCharacters;
    }

    public static boolean hasMoreDistinctCharThanK(String word, int k){
        Map<Character,Integer> wordCountMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {

            char currentChar = word.charAt(i);
            if(!wordCountMap.containsKey(currentChar)){
                wordCountMap.put(currentChar,1);
            }
        }

        //any entry in our map represents a new character
        int uniqueCharacters = wordCountMap.size();

        return uniqueCharacters > k;

    }

}
