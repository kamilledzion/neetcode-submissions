class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int[] prev = new int[arr.length];
        prev[prev.length - 1] = -1;
        
        for (int i = arr.length - 1; i > 0; i--) {
            max = Math.max(max, arr[i]);
            prev[i - 1] = max;
        }
        return prev;
    }
}