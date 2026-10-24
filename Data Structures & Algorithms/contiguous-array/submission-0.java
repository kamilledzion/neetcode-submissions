class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> mem = new HashMap<>();
        int sum = 0;
        int length = 0;
        mem.put(0, -1);

        for (int index = 0; index < nums.length; index++) {
            sum += nums[index] == 0 ? -1 : 1;
            
            if (mem.containsKey(sum)) {
                int prevIndex = mem.get(sum);
                length = Math.max(length, index - prevIndex);
            } else {
                mem.put(sum, index);
            }
        }

        return length;
    }
}
