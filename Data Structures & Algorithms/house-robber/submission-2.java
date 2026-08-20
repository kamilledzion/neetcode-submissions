class Solution {
    
    Map<Integer, Integer> mem = new HashMap<>();

    public int rob(int[] nums) {
        return dfs(nums, 0);
    }

    int dfs(int[] nums, int index) {
        if (index > nums.length - 1) {
            return 0;
        }
        if (mem.containsKey(index)) {
            return mem.get(index);
        }

        var rob1 = dfs(nums, index + 1);
        var rob2 = dfs(nums, index + 2) + nums[index];
        var res = Math.max(rob1 ,rob2);

        mem.put(index, res);
        return res;
    }
}
