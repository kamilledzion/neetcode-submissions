class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var mapOfCounts = new HashMap<Integer, Integer>();

        for (int i : nums) {
            mapOfCounts.compute(i, (key, v) -> v == null ? 1 : v + 1);
        }

        return mapOfCounts.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
