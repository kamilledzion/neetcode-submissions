class Solution {
    public int[] countBits(int n) {
        int size = n + 1;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = count(i);
        }
        return res;
    }

    int count(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }
}
