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
    public void reorderList(ListNode head) {
        ListNode slow = head;   
        ListNode fast = head;
        ListNode middle = null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }  
        middle = slow.next;
        slow.next = null;

        ListNode prev = null;
        while (middle != null) {
            ListNode node = new ListNode(middle.val, prev);
            prev = node;
            middle = middle.next;
        }

        while (prev != null) {
            ListNode nextHead = head.next;
            ListNode nextPrev = prev.next;
            head.next = prev;
            prev.next = nextHead;

            head = nextHead;
            prev = nextPrev;
        }
    }
}
