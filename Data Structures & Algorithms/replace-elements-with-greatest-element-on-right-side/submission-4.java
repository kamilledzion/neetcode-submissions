class Solution {
    public int[] replaceElements(int[] arr) {
        var max = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == 0) {
                arr[i] = max;
            } else {
                var curr = arr[i];
                arr[i] = max;
                max = Math.max(max, curr);
            }
        }

        return arr;
    }
}