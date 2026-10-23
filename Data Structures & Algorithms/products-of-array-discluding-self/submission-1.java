class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] leftSum = new int[size];
        int[] rightSum = new int[size];
        
        leftSum[0] = nums[0];
        for (int i = 1; i < size; i++) {
            leftSum[i] = leftSum[i - 1] * nums[i];
        }

        rightSum[size - 1] = nums[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] * nums[i];
        }

        int[] result = new int[size];
        for (int i = 0; i < size; i++) { 
            result[i] = (i - 1 < 0 ? 1 : leftSum[i - 1])
             * (i + 1 > size - 1 ? 1 : rightSum[i + 1]);
        }

        return result;
    }
}  
