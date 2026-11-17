class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        var start = 0;
        var end = nums.length - 1;

        while (start < end) {
            if (nums[start] == val) {
                if (nums[end] != val) {
                    nums[start] = nums[end];
                    nums[end] = val;
                    end--;
                    start++;
                } else {
                    end--;
                }
            } else {
                start++;
            }
        }

        return nums[start] == val ? start : start + 1;
    }
}