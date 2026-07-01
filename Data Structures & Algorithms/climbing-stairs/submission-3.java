class Solution {
    Map<Integer, Integer> memory = new HashMap<>();
    public int climbStairs(int n) {
        if (memory.containsKey(n)) {
            return memory.get(n);
        }

        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        var result = climbStairs(n - 1) + climbStairs(n - 2);   
        memory.put(n, result);
        return result;
    }
}

