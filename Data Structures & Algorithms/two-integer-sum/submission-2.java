class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mem = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int exp = target - nums[i];
            if (mem.containsKey(exp)) {
                return new int[]{mem.get(exp), i};
            }
            mem.put(nums[i], i);
        }

        return new int[]{};
    }
}
