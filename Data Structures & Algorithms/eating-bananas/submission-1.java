class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        var max = piles[0];
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(piles[i], max);
        }
        var result = max;
        var l = 1;
        var r = max;
        while (l <= r) {
            var mid = l + (r - l) / 2;
            var res = 0;
            for (int i = 0; i < piles.length; i++) {
                res += (piles[i] - 1 + mid) / mid;
            }  
            if (res <= h) { 
                r = mid - 1;
                result = Math.min(result, mid);
            } else if (res > h) {
                l = mid + 1;
            }
        }
        return result;
    }
}
