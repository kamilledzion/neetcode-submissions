class Solution {

    int[][] map;
    public int longestCommonSubsequence(String text1, String text2) {
        map = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(map[i], -1);
        }
        return dfs(text1, text2, 0, 0);
    }

    int dfs(String text1, String text2, int t1, int t2) {
        if (t1 == text1.length() || t2 == text2.length()) {
            return 0;
        }

        if (map[t1][t2] != -1) {
            return map[t1][t2];
        }

        if (text1.charAt(t1) == text2.charAt(t2)) {
            //map[t1][t2] = 1;
            return 1 + dfs(text1, text2, t1 + 1, t2 + 1);
        }

        return map[t1][t2] = Math.max(dfs(text1, text2, t1 + 1, t2), dfs(text1, text2, t1, t2 + 1));
    }
}
