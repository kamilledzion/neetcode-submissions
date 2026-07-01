class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count[0] = count[0] + 1;
            } else if (nums[i] == 1) {
                count[1] = count[1] + 1;
            } else if (nums[i] == 2) {
                count[2] = count[2] + 1;
            }
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            int k = count[i];
            while (k-- > 0) {
                nums[index++] = i;
            }
        }
    }
}