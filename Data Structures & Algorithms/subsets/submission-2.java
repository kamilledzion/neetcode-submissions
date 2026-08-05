class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        results.add(subset);

        for (int i = 0; i < nums.length; i++) {
            int currentSize = results.size();
            for (int s = 0; s < currentSize; s++) {
                subset = new ArrayList<>(results.get(s));
                subset.add(nums[i]);
                results.add(subset);
            }
        }

        return results;
    }
}
