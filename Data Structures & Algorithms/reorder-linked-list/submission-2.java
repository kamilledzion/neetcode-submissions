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
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow.next;
        slow.next = null;

        ListNode prev = null;
        while (middle != null) {
            ListNode tmp = middle.next;
            middle.next = prev;
            prev = middle;
            middle = tmp;
        }
        // 2 -> 4 -> 6 -> 8 -> 10
        // 2 -> 4 -> 6
        // 10 -> 8
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
