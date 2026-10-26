class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int size = nums.length;
        List<Integer>[] freq = new List[size + 1];
        Map<Integer, Integer> mem = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int val = nums[i];
            mem.put(val, mem.getOrDefault(val, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : mem.entrySet()) {
            if (freq[e.getValue()] == null) {
                freq[e.getValue()] = new ArrayList<>();
            }
            freq[e.getValue()].add(e.getKey());
        }

        for (int i = size; i >= 0; i--) {
            List<Integer> list = freq[i];
            if (list != null) {
                for (int j = 0; j < list.size(); j++) {
                    if (k == 0) {
                        return res;
                    }
                    res[k - 1] = list.get(j);
                    k--;
                }
            }
        }

        return res;
    }
}
