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

        int length = findLengthOptimalApproach(str, k);
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

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {

                String currentSubstring = str.substring(i, j);
                boolean hasDistinctChar = hasMoreDistinctCharThanK(currentSubstring, k);
                if (!hasDistinctChar) {
                    lengthOfLongestSubstringWithNoMoreThanKCharacters = Math.max(lengthOfLongestSubstringWithNoMoreThanKCharacters, currentSubstring.length());
                }

            }
        }


        return lengthOfLongestSubstringWithNoMoreThanKCharacters;
    }

    public static int findLengthOptimalApproach(String str, int k) {

        /*
            1. First, we will insert characters from the beginning of the string until we have K distinct characters in the HashMap.

            2. These characters will constitute our sliding window.
            We are asked to find the longest such window having no more than K distinct characters.
            We will remember the length of this window as the longest window so far.

            3. After this, we will keep adding one character in the sliding window (i.e., slide the window ahead)
            in a stepwise fashion.

            4.In each step, we will try to shrink the window from the beginning if the count of distinct characters
            in the HashMap is larger than K. We will shrink the window until we have no more than K distinct characters
             in the HashMap. This is needed as we intend to find the longest window.

            5. While shrinking, we’ll decrement the character’s frequency going out of the window and
            remove it from the HashMap if its frequency becomes zero.

            6.At the end of each step, we’ll check if the current window length is the longest so far,
            and if so, remember its length.

            The algorithm’s time complexity will be O(N) where N is the number of characters in the input string.
            The outer for loop runs for all characters, and the inner while loop processes each character only once;
            therefore, the time complexity of the algorithm will be O(N+N) which is asymptotically equivalent to O(N)

            The algorithm’s space complexity is O(K) as we will be storing a maximum of K+1 characters in the HashMap.
        */

        int windowStart = 0;
        int length = str.length();
        int lengthOfLongestSubstringWithNoMoreThanKCharacters = 0;
        HashMap<Character,Integer> wordCount = new HashMap<>();

        for (int windowEnd = 0; windowEnd < length; windowEnd++) {

            char currentChar = str.charAt(windowEnd);

            wordCount.put(currentChar, wordCount.getOrDefault(currentChar, 0) + 1);

            while(wordCount.size() > k){

                char leftMostChar = str.charAt(windowStart);

                wordCount.put(leftMostChar, wordCount.get(leftMostChar) -1);

                if(wordCount.get(leftMostChar) == 0){
                    wordCount.remove(leftMostChar);
                }

                windowStart++;
            }

            lengthOfLongestSubstringWithNoMoreThanKCharacters =
                    Math.max(lengthOfLongestSubstringWithNoMoreThanKCharacters, windowEnd - windowStart + 1);

        }

        return lengthOfLongestSubstringWithNoMoreThanKCharacters;

    }

    public static boolean hasMoreDistinctCharThanK(String word, int k) {
        Map<Character, Integer> wordCountMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {

            char currentChar = word.charAt(i);
            if (!wordCountMap.containsKey(currentChar)) {
                wordCountMap.put(currentChar, 1);
            }
        }

        //any entry in our map represents a new character
        int uniqueCharacters = wordCountMap.size();

        return uniqueCharacters > k;

    }

}
