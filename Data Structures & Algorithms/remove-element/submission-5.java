class Solution {
    public int removeElement(int[] nums, int val) {
       int remove = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[remove] = nums[i];
                remove++;
            }
        }

        return remove;
    }
}
