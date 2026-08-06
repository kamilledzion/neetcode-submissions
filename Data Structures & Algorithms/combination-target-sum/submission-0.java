class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, target, new ArrayList<>());
        return result;    
    }

    void dfs(int[] nums, int index, int target, List<Integer> subset) {
        if (index >= nums.length || target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, index, target - nums[index], subset);

        subset.removeLast();
        dfs(nums, index + 1, target, subset);
    }
}
