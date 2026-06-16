class Solution {
    public int removeElement(int[] nums, int val) {
        int remove = -1;
        int index = 0;
        while (index < nums.length) {
            if (remove == -1 && nums[index] == val) {
                remove = index;
            } else {
                if (remove != -1 && nums[index] != val) {
                    nums[remove] = nums[index];
                    nums[index] = val;
                    remove = remove + 1;
                }
            }
            index++;
        }
        return remove == -1 ? nums.length  : remove;
    }
}
