class Solution {
    public int numOfSubarrays(int[] arr) {
        int count = 0;
        int odd = 0;
        int even = 0;
        int sum = 0;

        for (int a : arr) {
            sum += a;
            if (sum % 2 == 1) {
                count = count + 1 + even;
                odd++;
            } else {
                count = count + odd;
                even++;
            }
        }

        return count;
    }
}