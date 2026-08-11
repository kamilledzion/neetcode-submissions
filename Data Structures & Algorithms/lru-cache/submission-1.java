class LRUCache {

    class Value {
        int key;
        int value;
        Value next;
        Value prev;

        Value(int key, int value, Value next, Value prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
                
        Value(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Value> map;
    Value head;
    Value tail;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.head = new Value(-99, -99, tail, null);
        this.tail = new Value(99, 99, null, head);
    }
    
    public int get(int key) {
        if  (!map.containsKey(key)) {
            return -1;
        } 
        
        var val = map.get(key);
        remove(val);
        addLast(val);

        return val.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            var val = map.get(key);
            remove(val);
            val.value = value;
            addLast(val);
        } else {
            if (capacity == map.size()) {
                map.remove(head.next.key);
                remove(head.next);
            }

            Value val = new Value(key, value);
            addLast(val);
        }
    }

    void addLast(Value val) {
        map.put(val.key, val);
        tail.prev.next = val;
        val.prev = tail.prev;

        val.next = tail;
        tail.prev = val;
    }

    void remove(Value val) {
        val.prev.next = val.next;
        val.next.prev = val.prev;
    }
}
