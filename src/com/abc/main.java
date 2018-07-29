package com.abc;

public class main {
    public static void main(String[] args) {

//        AddTwoNumbers2 t = new AddTwoNumbers2();
//
//        ListNode l1, l1n, l2, l2n;
//        l1 = new ListNode(2);l1n = l1;
//        l1n.next = new ListNode(4);l1n=l1n.next;
//        l1n.next = new ListNode(3);l1n=l1n.next;
//
//        l2 = new ListNode(5);l2n = l2;
//        l2n.next = new ListNode(6);l2n=l2n.next;
//        l2n.next = new ListNode(4);l2n=l2n.next;
//
//        t.addTwoNumbers(l1, l2);


        Median4 m4 = new Median4();
        int[] n1 = {1,2};
        int[] n2 = {3};

        System.out.println(m4.findMedianSortedArrays(n1, n2));
    }
}
