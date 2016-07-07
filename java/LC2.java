// 2016-2-12

package com.chris.leetcode;

public class LC2 {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode helper = new ListNode(-1), cur = helper;
        int carry = 0;
        while(l1 != null || l2 != null){
            cur.next = new ListNode(-1);
            cur = cur.next;
            cur.val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = cur.val / 10; cur.val %= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1){
            cur.next = new ListNode(1);
        }
        return helper.next;
    }

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		LC2 lc2 = new LC2();
		ListNode l3 = lc2.addTwoNumbers(l1, l2);
		while(l3 != null){
			System.out.println(l3.val);
			l3 = l3.next;
		}

	}

}
