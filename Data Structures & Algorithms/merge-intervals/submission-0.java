class Solution {
    public int[][] merge(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i[] : intervals) {
            map.merge(i[0], i[1], (i1, i2) -> i1 > i2 ? i1 : i2);
        }

        int[][]res = new int[map.size()][2];
        int prevEnd = -1;
        int index = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int start = m.getKey();
            int end = m.getValue();

            if (prevEnd >= start) {
                index--;
                res[index][1] = Math.max(res[index][1], end);
            } else {
                res[index][0] = start;
                res[index][1] = end;
            }
            prevEnd = res[index][1];

            index++;
        }

        return Arrays.copyOf(res, index);
    }
}
