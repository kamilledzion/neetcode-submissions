class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int left[] = new int[len];
        int right[] = new int[len];
        int res[] = new int[len];

        left[0] = nums[0];
        for (int i = 1; i < len - 1; i++) {
            left[i] = nums[i] * left[i - 1];
        }

        right[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = nums[i] * right[i + 1];
        }

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                res[i] = right[i + 1];
            } else if (i == len - 1) {
                res[i] = left[i - 1];
            } else {
                res[i] = left[i - 1] * right[i + 1]; 
            }
        }

        return res;
    }
}  
