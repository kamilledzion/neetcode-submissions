class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int index = (right + left) / 2;
            int mid = nums[index];
            if (mid == target) {
                return index ;
            } else if (mid < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return -1;
    }
}
