package com.jworks.patterns.fastandslowpointers;

import java.util.HashSet;

public class LinkedListCycle {

//    Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycleOptimal(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycleOptimal(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycleOptimal(head));
    }

    public static boolean hasCycleOptimal(ListNode head){

        /*
         * Time complexity : 0(N)
         *  Space Complexity: 0(1)
         * */

        ListNode slowNode = head;
        ListNode fastNode = head;

        while(fastNode != null && fastNode.next != null){

            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if(fastNode == slowNode) return true;
        }
        return false;
    }


    public static boolean hasCycleNaive(ListNode head) {

        /*
        * Time complexity & Space Complexity: 0(N)
        * */

        HashSet<ListNode> listNodeHashSet = new HashSet<>();

        ListNode currentNode = head;

        while ( currentNode != null){
            if (!listNodeHashSet.add(currentNode)) return true;
            currentNode = currentNode.next;
        }

        return false;
    }
}
