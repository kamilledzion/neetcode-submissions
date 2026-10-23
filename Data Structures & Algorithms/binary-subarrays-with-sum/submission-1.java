class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int count = 0;
        int sum = 0;

        prefixSum.put(0, 1);
        for (int i : nums) {
            sum += i;
            int exists = prefixSum.getOrDefault(sum - goal, 0);
            if (exists != 0) {
                count += exists;
            } 
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}