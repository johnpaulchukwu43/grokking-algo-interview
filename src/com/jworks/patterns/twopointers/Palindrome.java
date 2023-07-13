package com.jworks.patterns.twopointers;

public class Palindrome {


    public static boolean isPalindrome(String s) {

        /*

        * We make use of two pointers P1 and P2
        * P1 starts from the beginning of the string
        * P2 starts from the end of the string
        *
        * At each iteration we compare P1 and P2
        * if P2 does not P1 at any point we return false
        *
        * if P1 and P2 match and are both are the middle we return true
        * */int p1 = 0;

        int p2 = s.length() -1;

        while (p1 < p2){

            if(s.charAt(p1) != s.charAt(p2)){
                return false;
            }

            p1++;
            p2--;
        }

        return true;
    }
}
