/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode();
        ListNode itr = result;
        while(l1 != null && l2 != null) {
            int total = l1.val + l2.val + carry;
            carry = total/10;
            itr.next = new ListNode(total%10);
            l1 = l1.next;
            l2 = l2.next;
            itr = itr.next;
        }
        ListNode unprocessedList = l1 != null ? l1 : l2;
        while(unprocessedList != null) {
            int total = unprocessedList.val + carry;
            carry = total/10;
            itr.next = new ListNode(total%10);
            unprocessedList = unprocessedList.next;
            itr = itr.next;
        }
        if(carry == 1)
            itr.next = new ListNode(1);
        return result.next;
    }
}