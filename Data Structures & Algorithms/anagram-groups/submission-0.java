class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mem = new HashMap<>();
        for (String s : strs) {
            char[] tab = s.toCharArray();
            Arrays.sort(tab);
            String sorted = new String(tab);
            mem.putIfAbsent(sorted, new ArrayList<String>());
            mem.get(sorted).add(s);
        }

        return new ArrayList<>(mem.values());
    }
}
