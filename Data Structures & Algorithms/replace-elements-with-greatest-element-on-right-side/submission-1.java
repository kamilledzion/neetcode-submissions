class Solution {
    public int[] replaceElements(int[] arr) {
        int size = arr.length;
        int[] res = new int[size];
        int max = -1;
        res[size - 1] = max;
        for (int i = size - 2; i >= 0; i--) {
            res[i] = Math.max(res[i + 1], arr[i + 1]);
        }
        return res;
    }
}