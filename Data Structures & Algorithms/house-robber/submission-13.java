class Solution {
    public int rob(int[] nums) {
        var size = nums.length;

        if (size == 1) {
            return nums[0];
        } 
        if (size == 2) {
            return Math.max(nums[0], nums[1]);
        } 

        var rob1 = nums[0];
        var rob2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            var next = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = next;
        }

        return rob2;
    }
}
