class Solution {
    public int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            return new int[] {-1};
        }

        var max = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (i == 0) {
                arr[i] = max;
            } else {
                var curr = arr[i];
                arr[i] = max;
                max = Math.max(max, curr);
            }
        }

        arr[arr.length -1] = -1;
        
        return arr;
    }
}