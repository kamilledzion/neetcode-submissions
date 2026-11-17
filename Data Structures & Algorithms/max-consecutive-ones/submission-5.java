class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        var start = -1;
        var result = 0;

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (start == -1) {
                    start = i;
                } else {
                    if (i == nums.length - 1) {
                        result = Math.max(result, i - start +1);
                    }
                }
            } else {
                if (start != -1) {
                    result = Math.max(result, i - start);
                    start = -1;
                } 
            }
        }


        return result;
    }
}