class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mem = new HashMap<>();
        for (int n : nums) {
            int value = mem.getOrDefault(n, 0);
            mem.put(n, value + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> e : mem.entrySet()) {
            freq[e.getValue()].add(e.getKey());
        }
        
        int res[] = new int[k];
        int idx = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            for (int value : freq[i]) {
                res[idx] = value;
                if (idx + 1 == k) {
                    return res;
                }
                idx++;
            };
        }
        return res;
    }
}
