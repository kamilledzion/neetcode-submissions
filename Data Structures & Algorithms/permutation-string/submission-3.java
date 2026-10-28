class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> mem1 = new HashMap<>();
        Map<Character, Integer> mem2 = new HashMap<>();
        int win = s1.length();

        for (Character ch : s1.toCharArray()) {
            mem1.put(ch, mem1.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            Character ch = s2.charAt(right);
            mem2.put(ch, mem2.getOrDefault(ch, 0) + 1);

            if (right - left + 1 == win) {
                boolean eq = true;
                for (Map.Entry<Character, Integer> e : mem1.entrySet()) {
                    if (e.getValue() != mem2.getOrDefault(e.getKey(), 0)) {
                        eq = false;
                        break;
                    }
                }

                if (eq) {
                    return true;
                }

                ch = s2.charAt(left);
                mem2.put(ch, mem2.getOrDefault(ch, 0) - 1);
                left++;
            }
            right++;
        }

        return false;
    }
}
