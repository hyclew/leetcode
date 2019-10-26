package com.abc.quiz;

import com.abc.util.ListNode;

public class Q0002 {

    public static void main(String[] args) {

        Q0002 t = new Q0002();

        ListNode l1, l1n, l2, l2n;
        l1 = new ListNode(2);l1n = l1;
        l1n.next = new ListNode(4);l1n=l1n.next;
        l1n.next = new ListNode(3);l1n=l1n.next;

        l2 = new ListNode(5);l2n = l2;
        l2n.next = new ListNode(6);l2n=l2n.next;
        l2n.next = new ListNode(4);l2n=l2n.next;

        t.addTwoNumbers(l1, l2);

        System.out.println(t);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode p = l1, q = l2, l = null, l3Head, curr;
        int sum = 0;
        int carry = 0;


        l3Head = new ListNode((p.val + q.val + carry) % 10);
        carry = (p.val + q.val) / 10;
        p = p.next;
        q = q.next;
        curr = l3Head;

        while (p != null && q != null) {
            sum = p.val + q.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);

            curr = curr.next;
            p = p.next;
            q = q.next;

        }

        if (p != null) {
            l = p;
        }
        if (q != null) {
            l = q;
        }
        curr.next = l;
        if (carry == 0) {
            return l3Head;
        }

        while (l != null && carry == 1) {
            sum = l.val + carry;
            carry = sum / 10;
            l.val = sum % 10;

            curr.next = l;
            curr = curr.next;
            l = l.next;
        }

        if (l == null && carry == 1) {
            curr.next = new ListNode(1);
        }

        return l3Head;
    }
}

