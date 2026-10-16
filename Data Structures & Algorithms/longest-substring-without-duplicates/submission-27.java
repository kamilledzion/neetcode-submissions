class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        for (Character ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                max = Math.max(max, right - left);
                left = Math.max(left, map.get(ch) + 1);
            } 
            map.put(ch, right);
            right++;
        }

        return Math.max(max, right - left);
    }
}
