class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            var val = map.getOrDefault(ch, 0);
            map.put(ch, val + 1);
        }

        for (Character ch : t.toCharArray()) {
            var val = map.get(ch);
            if (val == null) {
                return false;
            } else {
                if (val - 1 == 0) {
                    map.remove(ch);
                } else {
                    map.put(ch, val - 1);
                }
            }
        }
        
        return map.isEmpty();
    }
}
