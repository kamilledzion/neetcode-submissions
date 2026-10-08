class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int n : nums) {
            sum += n;
            int diff = sum - k;
            int prefSum = map.getOrDefault(diff, 0);
            res += prefSum;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}