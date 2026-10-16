class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int freq = 0;
        int max = 0;
        Map<Character, Integer> mem = new HashMap<>();

        while (right < s.length()) {
            Character c = s.charAt(right);
            mem.put(c, mem.getOrDefault(c, 0) + 1);
            freq = Math.max(freq, mem.get(c));

            if ((right - left + 1) - freq > k) {
                int count = mem.get(s.charAt(left));
                mem.put(s.charAt(left), count - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
