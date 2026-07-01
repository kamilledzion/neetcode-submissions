class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var tmp = new int[m + n];

        var k = 0;
        var left = 0;
        var right = 0;
        while (left < m && right < n) {
            if (nums1[left] < nums2[right]) {
                tmp[k++] = nums1[left++]; 
            } else {
                tmp[k++] = nums2[right++]; 
            }
        }

        while (left < m) {
            tmp[k++] = nums1[left++];
        }

        while (right < n) {
            tmp[k++] = nums2[right++];
        }

        for (k = 0; k < tmp.length; k++) {
            nums1[k] = tmp[k];
        }
    }
}