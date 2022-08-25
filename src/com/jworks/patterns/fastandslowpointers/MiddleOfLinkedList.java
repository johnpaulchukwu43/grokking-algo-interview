package com.jworks.patterns.fastandslowpointers;

public class MiddleOfLinkedList {

    /*
    * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.

       If the total number of nodes in the LinkedList is even, return the second middle node.
    *
    * */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
    }


    public static ListNode findMiddle(ListNode head) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer != null && fastPointer.next != null){

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}
