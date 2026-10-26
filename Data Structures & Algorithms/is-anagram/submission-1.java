class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mem = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            mem.put(ch, mem.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : t.toCharArray()) {
            if (!mem.containsKey(ch)) {
                return false;
            }
            int count = mem.get(ch) - 1;
            mem.put(ch, count);
            if (count == 0) {
                mem.remove(ch);
            }
        }

        return mem.size() == 0;
    }
}
