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

class MyStack {

    Node head;
    int size;

    public MyStack() {
        head = new Node(0); 
        size = 0;   
    }
    
    public void push(int x) {
        Node node = new Node(head, x, null);
        head.next = node;
        head = node;
        size++;
    }
    
    public int pop() {
        size--;
        var val = head.val;
        head = head.prev;
        return val;
    }
    
    public int top() {
        return head.val;
    }
    
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */