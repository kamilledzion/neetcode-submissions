
class Node {

    int val;
    Node prev = null;
    Node next = null;

    public Node(int val) {
        this.val = val;
    }
}

class MyLinkedList {

    Node head = null;
    int size = 0;

    public MyLinkedList() {
    }
    
    public int get(int index) {
        int i = 0;
        var tmp = head;
        while (index != i) {
            tmp = tmp.next;
            i++;
        }
        return tmp.val;
    }
    
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node node = new Node(val);
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        var tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
        node.prev = tmp;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            head = new Node(val);
            return;
        }
        if (index >= size) {
            addAtTail(val);
        }
        Node node = new Node(val);
        int i = 0;
        var tmp = head;
        while (index != i) {
            tmp = tmp.next;
            i++;
        }
        tmp.prev.next = node;
        node.next = tmp;
        node.prev = tmp.prev;
        tmp.prev = node;     
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }
        int i = 0;
        var tmp = head;
        while (index != i) {
            tmp = tmp.next;
            i++;
        }
        if (tmp.next != null) {
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
        }   
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