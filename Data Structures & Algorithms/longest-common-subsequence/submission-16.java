class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int size1 = text1.length();
        int size2 = text2.length();
        int[] prev = new int[size2 + 1];

        for (int t1 = size1 - 1; t1 >= 0; t1--) {
            int[] curr = new int[size2 + 1];
            for (int t2 = size2 - 1; t2 >= 0; t2--) {
                if (text1.charAt(t1) == text2.charAt(t2)) {
                    curr[t2] = 1 + prev[t2 + 1];
                } else {
                    curr[t2] = Math.max(curr[t2 + 1], prev[t2]);
                }
            }
            prev = curr;
        }
        return prev[0];
    }
}
