class Solution {
    public int rob(int[] nums) {
        var size = nums.length;
        int[] h = new int[size];
        h[0] = nums[0];
        if (size == 1) {
            return h[0];
        } 
        h[1] = Math.max(nums[0], nums[1]);
        if (size == 2) {
            return h[1];
        } 

        for (int i = 2; i < nums.length; i++) {
            var rob = nums[i] + h[i - 2];
            var skip = h[i - 1];

            h[i] = Math.max(rob, skip); 
        }

        return h[nums.length - 1];
    }
}
