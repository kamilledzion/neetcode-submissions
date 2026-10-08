class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> mem = new HashSet<>();
        for (int n : nums) {
            mem.add(n);
        }
        int max = 1;
        for (int n : nums) {
            if (mem.contains(n + 1)) {
                continue;
            }
            int tmpMax = 1;
            while (mem.contains(--n)) {
                tmpMax++;
            }
            max = Math.max(tmpMax, max);
        }

        return max;
    }
}
