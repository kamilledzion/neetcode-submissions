
class Node {
    int val;
    Node next;
    Node prev;

    Node(int val, Node prev, Node next) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }    

    Node(int val) {
        this.val = val;
    }  
}

class MyLinkedList {

    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        return getNode(index + 1).val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        Node prev = getNode(index);
        Node next = getNode(index + 1);

        Node node = new Node(val, prev, next);
        prev.next = node;
        next.prev = node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node prev = getNode(index);
        Node next = getNode(index + 2);

        prev.next = next;
        next.prev = prev;
        size--;
    }

    public Node getNode(int index) {
        Node curr = head;
        int i = 0;
        while (curr != null && index != i) {
            curr = curr.next;
            i++;
        }
        return curr;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */