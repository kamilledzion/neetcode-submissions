class Solution {
    public int[] twoSum(int[] nums, int target) {
        var end = nums.length - 1;
        var start = 0;

        while (start < end) {
            var diff = target - nums[start];
            var endValue = nums[end];
            if (diff == endValue) {
                return new int[]{start + 1, end + 1};
            }
            if (diff < endValue) {
                end--;
            } else {
                start++;
            }
        }

        return new int[]{0, 0};
    }
}
