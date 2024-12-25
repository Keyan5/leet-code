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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode itr = head;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                itr.next = list1;
                list1 = list1.next;
            }
            else {
                itr.next = list2;
                list2 = list2.next;
            }
            itr = itr.next;
        }
        ListNode rem_list = list1 == null ? list2 : list1;
        while(rem_list != null) {
            itr.next = rem_list;
            rem_list = rem_list.next;
            itr = itr.next;
        }
        return head.next;
    }
}