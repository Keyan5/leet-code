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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode start = dummy, end = dummy;
        while(n-->=0) end = end.next;
        while(end != null) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return dummy.next;
    }
}