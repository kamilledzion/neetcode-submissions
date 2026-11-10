class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    
        int[][] res = new int[intervals.length][2];
        int start = intervals[0][0];
        int end = intervals[0][1];
        int k = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res[k][0] = start;
                res[k++][1] = end;
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res[k][0] = start;
        res[k][1] = end;

        return Arrays.copyOf(res, k + 1);
    }
}
