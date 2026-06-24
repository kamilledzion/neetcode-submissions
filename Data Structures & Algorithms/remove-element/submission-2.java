class Solution {
    public int removeElement(int[] nums, int val) {
        int remove = -1;
        int index = 0;
        // 3, 2, 2, 3
        // 2, 3, 2, 3
        // 2, 2, 3 ,3, 4

        while (index < nums.length) {
            if (remove == -1 && nums[index] == val) {
                remove = index;
            } else {
                if (remove != -1 && nums[index] != val) {
                    // replace
                    nums[remove] = nums[index];
                    nums[index] = val;
                    remove = remove + 1;
                }
            }
            index++;
        }
        return remove == -1 ? 0 : remove;
    }
}
