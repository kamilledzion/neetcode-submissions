class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mem = new HashMap<>();
        int sum = 0;
        int count = 0;

        mem.put(0, 1);
        for (int n : nums) {
            sum += n;
            int exp = sum - k;
            if (mem.containsKey(exp)) {
                count += mem.get(exp);
            }
            
            mem.put(sum, mem.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}