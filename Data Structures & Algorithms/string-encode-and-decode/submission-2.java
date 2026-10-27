class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            builder.append(s.length());
            builder.append('#');
            builder.append(s);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        int left = 0;
        int right = 0;
        List<String> res = new ArrayList<>();
        // 5#Hello5#World
        while (right < str.length()) {
            if (str.charAt(right) == '#') {
                int count = Integer.parseInt(str.substring(left, right));
                int start = right + 1;
                int end = start + count;
                res.add(str.substring(start, end));
                left = end;
                right = left;
            }
            right++;
        }

        return res;
    }
}
