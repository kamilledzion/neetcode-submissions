class Solution {
    public int[] replaceElements(int[] arr) {
        var result = new int[arr.length];

        result[arr.length - 1] = -1;

        if (arr.length == 1) {
            return result;
        }

        result[arr.length - 2] = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            result[i - 1] = Math.max(arr[i], result[i]);
        }

        return result;
    }
}