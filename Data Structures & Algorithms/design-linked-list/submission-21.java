class Node {

    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(Node prev, int val, Node next) {
        this.prev = prev;
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {

    int size;
    Node head;
    Node tail;

    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int get(int index) {
        return getPrev(index + 1).val;
    }

    private Node getPrev(int index) {
        if (index > size || index < 0) {
            return new Node(-1);
        }
        var curr = head;
        while (curr != null && index > 0) {
            curr = curr.next;
            index--;
        }
        return curr;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }        
        var prev = getPrev(index);
        Node node = new Node(prev, val, prev.next);
        prev.next = node;
        prev.next.prev = node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index > size || index < 0) {
            return;
        }      
        var prev = getPrev(index);
        prev.next = prev.next.next;
        prev.next.prev = prev;
        size--;
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