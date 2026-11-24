class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var mapOfStrings = new HashMap<String, List<String>>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            mapOfStrings.computeIfAbsent(sorted, k -> new ArrayList<>())
                    .add(s);
        };

        return mapOfStrings.values().stream().toList();
    }
}
