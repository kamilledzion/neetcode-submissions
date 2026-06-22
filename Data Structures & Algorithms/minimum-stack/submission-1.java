class MinStack {
    List<Integer> list;
    List<Integer> min;
    public MinStack() {
        list = new ArrayList<>();
        min = new ArrayList<>();
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
        list.remove(list.size() - 1);
        min.remove(min.size() - 1);
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return min.get(min.size() - 1);
    }
}
