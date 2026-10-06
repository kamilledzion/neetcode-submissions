class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mem = new HashMap<>();
        int currIdx = 0;
        for (int n : nums) {
            int missing = target - n;
            int index = mem.getOrDefault(missing, -1);
            if (index != -1) {
                return new int[]{index, currIdx};
            }
            mem.put(n, currIdx);

            currIdx++;
        } 
        return new int[]{0, 0};
    }
}
