/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode secondLast = null;
        while(node.next != null) {
             node.val = node.next.val;
             secondLast = node;
             node = node.next;
        }
        secondLast.next = null;
    }
}