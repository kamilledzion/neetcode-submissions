class Solution {
    public int[] twoSum(int[] nums, int target) {
        var diffs = new HashMap<Integer, Integer>();
        var result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            
            if (diffs.get(nums[i]) != null) {
                result[1] = i;
                result[0] = diffs.get(nums[i]);
                return result; 
            }

            var diff = target - nums[i];
            diffs.put(diff, i);
        }

        return result;
    }
}
