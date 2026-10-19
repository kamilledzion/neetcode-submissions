class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mem = new HashMap<>();
        int max = 0;
        int freq = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            Character letter = s.charAt(right);
            int count = mem.getOrDefault(letter, 0) + 1;
            mem.put(letter, count); 
            freq = Math.max(freq, count);

            while ((right - left + 1) - freq > k) {
                letter = s.charAt(left);
                count = mem.get(letter);
                count--;
                mem.put(letter, count); 
                freq = Math.max(freq, count);
                left++;
            }

            max = Math.max(max, right - left + 1);       
        }

        return max;
    }
}
