class MinStack {
    LinkedList<Integer> list;
    LinkedList<Integer> min;
    public MinStack() {
        list = new LinkedList<>();
        min = new LinkedList<>();
    }
    
    public void push(int val) {
        list.add(val);
        if (min.size() == 0) {
            min.add(val);
        } else {
            min.add(Math.min(min.getLast(), val));
        }
    }
    
    public void pop() {
        list.removeLast();
        min.removeLast();
    }
    
    public int top() {
        return list.getLast();
    }
    
    public int getMin() {
        return min.getLast();
    }
}
