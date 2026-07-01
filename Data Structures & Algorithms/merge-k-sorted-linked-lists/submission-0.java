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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return divide(lists, 0, lists.length - 1);
    }

    public ListNode divide(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        var mid = (left + right) / 2;

        ListNode leftNode = divide(lists, left, mid);
        ListNode rightNode = divide(lists, mid + 1, right);

        return merge(leftNode, rightNode);
    }

    public ListNode merge(ListNode leftNode, ListNode rightNode) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                node.next = leftNode;
                leftNode = leftNode.next;
            } else {
                node.next = rightNode;
                rightNode = rightNode.next; 
            }
            node = node.next;
        }

        while (leftNode != null ) {
            node.next = leftNode;
            node = node.next;
            leftNode = leftNode.next;
        }

        while (rightNode != null ) {
            node.next = rightNode;
            node = node.next;
            rightNode = rightNode.next;
        }
        return dummy.next;
    }
}
