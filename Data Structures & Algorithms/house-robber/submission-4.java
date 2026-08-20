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

        var skip = dfs(nums, index + 1);
        var rob = dfs(nums, index + 2) + nums[index];
        var res = Math.max(skip ,rob);

        mem.put(index, res);
        return res;
    }
}
