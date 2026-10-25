class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vol = Set.of('a', 'e', 'i', 'o', 'u');
        int[] count = new int[words.length + 1];
        
        for (int i = 0; i < words.length; i++) {
            count[i + 1] = count[i] + 
                (vol.contains(words[i].charAt(0)) && vol.contains(words[i].charAt(words[i].length() - 1)) ? 1 : 0);
        }

        int[] res = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            res[i] = count[q[1] + 1] - count[q[0]];
            i++;
        }

        return res;
    }
}