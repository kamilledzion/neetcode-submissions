class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var val = target - nums[i];
            if (valToIdx.get(val) != null) {
                return new int[]{valToIdx.get(val), i};
            } 
            valToIdx.put(nums[i], i);
        }
        return new int[]{};
    }
}
