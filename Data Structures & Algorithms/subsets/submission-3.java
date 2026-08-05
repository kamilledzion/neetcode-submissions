class Solution {

    List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();

        dfs(nums, 0, subset);

        return results;
    }

    void dfs(int[] nums, int index, List<Integer> subset) {
        if (index >= nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, index + 1, subset);

        subset.removeLast();
        dfs(nums, index + 1, subset);
    }

}
