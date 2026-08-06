class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, 0, target, 0, new ArrayList<>());
        return result;    
    }

    void dfs(int[] nums, int index, int target, int sum, List<Integer> subset) {
        if (target == sum) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                return;
            }
            subset.add(nums[i]);
            dfs(nums, i, target, sum + nums[i], subset);
            subset.removeLast();
        }
    }
}
