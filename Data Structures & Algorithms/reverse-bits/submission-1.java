class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            var bit = n & 1;
            n = n >> 1;
            res = res << 1;
            res = res | bit;
        }

        return res;
    }
}
