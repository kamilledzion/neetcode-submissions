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
        ListNode root = new ListNode(0);
        ListNode head = root;
        while (list1 != null && list2 != null) {
            ListNode node;
            if (list1.val < list2.val) {
                node = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                node = new ListNode(list2.val);
                list2 = list2.next;
            }
            root.next = node;
            root = node;
        }
        if (list1 != null) {
            root.next = list1;
        }
        if (list2 != null) {
            root.next = list2;
        }

        return head.next;
    }
}