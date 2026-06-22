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
        // iteration
        ListNode merged = new ListNode(0);
        ListNode head = merged;
        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;

            if (val2 > val1) {
                merged.next = list1;
                list1 = list1.next;
            } else {
                merged.next = list2;
                list2 = list2.next;  
            }
            merged = merged.next;
        }
        while (list1 != null) { 
            merged.next = list1;
            list1 = list1.next;
            merged = merged.next;
        }
        while (list2 != null) { 
            merged.next = list2;
            list2 = list2.next;
            merged = merged.next;
        }

        return head.next;
    }
}