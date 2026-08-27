class MinStack {

    List<Integer> list;
    int size = 0;
    List<Integer> min;

    public MinStack() {
        list = new ArrayList<>();    
        min = new ArrayList<>(); 
    }
    
    public void push(int val) {
        if (min.isEmpty()) {
            min.add(val);
        } else {
            int lastMin = min.get(lastIndex());
            min.add(Math.min(lastMin, val));
        }
        list.add(val);
        size++;
    }
    
    public void pop() {
        list.remove(lastIndex());
        min.remove(lastIndex());
        size--;
    }
    
    public int top() {
        return list.get(lastIndex());
    }
    
    public int getMin() {
        return min.get(lastIndex());
    }

    private int lastIndex() {
        return size - 1;
    }
}
