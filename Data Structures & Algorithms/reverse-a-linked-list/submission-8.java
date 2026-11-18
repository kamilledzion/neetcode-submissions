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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev; 
            prev = head;
            head = tmp;
        }
        return prev;
        // null(prev) <- 0(head)  1(tmp) -> 2 -> 3
        
        // null <- 0(prev)  1(head) -> 2 -> 3
    }
}
