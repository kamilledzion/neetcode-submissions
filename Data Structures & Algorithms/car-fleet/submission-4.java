class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        int len = position.length;

        for (int i = 0; i < len; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a , b) -> Integer.compare(a[0], b[0]));

        int count = 1;
        double next = (double) (target - pair[len - 1][0]) / pair[len - 1][1];
        for (int i = len - 2; i >= 0; i--) {
            double curr = (double) (target - pair[i][0]) / pair[i][1];
            if (curr > next) {
                count++;
                next = curr;
            }
        }

        return count;
    }
}
