class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> mem = new HashMap<>();
        mem.put(s.charAt(left), left);

        for (int i = 1; i < s.length(); i++) {
            Character val = s.charAt(i);

            if (!mem.containsKey(val)) {
                mem.put(val, i);
                right = i;
                continue;
            }
            max = Math.max(max, right - left + 1);
            left = Math.max(left, mem.get(val) + 1);
            right = i;
            mem.put(val, i);
        }

        max = Math.max(max, right - left + 1);

        return max;
    }
}
