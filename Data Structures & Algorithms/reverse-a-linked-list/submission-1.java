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
    // recursion
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // iteration
    // public ListNode reverseList(ListNode head) {
    //     ListNode prev = null;
    //     while (head != null) {
    //         var tmp = head.next;
    //         head.next = prev;
    //         prev = head;
    //         head = tmp;
    //     }
    //     return prev;
    // }
}
