class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> piority = new PriorityQueue<>(Comparator.comparing(a ->a[0]));
        for (int i = 0; i < points.length; i++){
            var result = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            piority.offer(new int[]{result, points[i][0], points[i][1]});
        }        

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = piority.poll();
            result[i] = new int[] {point[1], point[2]};
        }
        return result;
    }
}
