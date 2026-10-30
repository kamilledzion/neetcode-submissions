class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = piles.length - 1;
        for (int p : piles) {
            right = Math.max(p, right);
        }

        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long hours = 0;

            for (int p : piles) {
                hours += p / mid;
                if (p % mid != 0) {
                    hours++;
                }
            }

            if (hours <= h) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}
