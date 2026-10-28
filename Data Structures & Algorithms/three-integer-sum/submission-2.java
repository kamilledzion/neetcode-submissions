class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int a = 0;
        int b = 0;
        int c = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                b = nums[left];
                c = nums[right];
                if(a + b + c < 0) {
                    left++;
                } else if (a + b + c > 0) {
                    right--;
                } else {
                    res.add(List.of(a, b, c));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
