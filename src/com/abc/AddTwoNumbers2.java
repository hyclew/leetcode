package com.abc;

public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode l3Head = null;

        ListNode p = l1, q = l2, l = null, curr = null;
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

