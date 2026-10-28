class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length) {
            int buy = prices[left];
            int sell = prices[right];
            if (sell > buy) {
                max = Math.max(max, sell - buy);
                right++;
            } else {
                left++;
            }
            if (left == right) {
                right++;
            }
        }

        return max;
    }
}
