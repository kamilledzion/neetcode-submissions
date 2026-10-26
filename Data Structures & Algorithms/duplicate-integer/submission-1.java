class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> mem = new HashSet<>();
        for (int i : nums) {
            if (mem.contains(i)) {
                return true;
            } else {
                mem.add(i);
            }
        }
        return false;
    }
}