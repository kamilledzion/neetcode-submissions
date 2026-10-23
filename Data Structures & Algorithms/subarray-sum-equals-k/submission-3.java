class Solution {
    public int subarraySum(int[] nums, int k) {
        int size = nums.length;
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0, 1);
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            int exist = prefixSum.getOrDefault(sum - k, 0);
            
            if (exist != 0) {
                count += exist;
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
