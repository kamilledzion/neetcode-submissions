class MinStack {

    Stack<Integer> s;
    Stack<Integer> min;

    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        if (min.isEmpty()) {
            min.push(val);
        } else {
            min.push(Math.min(min.peek(), val));
        }
        s.push(val);
    }
    
    public void pop() {
        min.pop();
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
