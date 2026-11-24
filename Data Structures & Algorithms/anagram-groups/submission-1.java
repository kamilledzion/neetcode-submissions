class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var mapOfStrings = new HashMap<String, List<String>>();

        for (String s : strs) {
            var sorted = Arrays.stream(s.split("")).sorted().collect(Collectors.joining());
            mapOfStrings.computeIfAbsent(sorted, k -> new ArrayList<>())
                    .add(s);
        };

        return mapOfStrings.values().stream().toList();
    }
}
