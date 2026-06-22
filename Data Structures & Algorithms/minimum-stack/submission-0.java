class MinStack {
    List<Integer> list;
    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
    }
    
    public void pop() {
        list.remove(list.size() - 1);
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        var min = Integer.MAX_VALUE;;
        for (int value : list) {
            min = Math.min(min, value);
        }
        return min;
    }
}
