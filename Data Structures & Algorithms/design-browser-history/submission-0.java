class Node {

    String url;
    Node prev;
    Node next;

    public Node(String url) {
        this.url = url;
    }
}

class BrowserHistory {

    Node head;

    public BrowserHistory(String homepage) {
         head = new Node(homepage);
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        head.next = node;
        node.prev = head;
        head = node;
    }
    
    public String back(int steps) {
        int i = 0;
        while (i < steps && head.prev != null) {
            i++;
            head = head.prev;
        }
        return head.url;
    }
    
    public String forward(int steps) {
        int i = 0;
        while (i < steps && head.next != null) {
            i++;
            head = head.next;
        }
        return head.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */