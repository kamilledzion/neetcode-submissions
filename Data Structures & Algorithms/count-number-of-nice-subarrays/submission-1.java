class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> mem = new HashMap<>();
        int count = 0;
        int oddCount = 0;
        mem.put(0, 1);
        
        for (int i : nums) {
            oddCount += i % 2;
            int leftOdd = oddCount - k;
            int exists = mem.getOrDefault(leftOdd, 0);
            if (exists != 0) {
                count += exists;
            }
            mem.put(oddCount, mem.getOrDefault(oddCount, 0) + 1);
        }
        return count;
    }
}
// 2, 1, 2
// count odd = left odd + right odd (k)
// left odd = count odd - right odd (k)