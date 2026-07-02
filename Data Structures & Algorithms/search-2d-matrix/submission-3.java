class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        var left = 0;
        var right = matrix.length - 1;
        var mid = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if (target < matrix[mid][0]) {
                right = mid - 1;
            } else if (target > matrix[mid][matrix[mid].length - 1]) {
                left = mid + 1;
            } else {
                break;
            }
        }

        int[] tab = matrix[mid];
        var tabLeft = 0;
        var tabRight = matrix[mid].length - 1;
        while (tabLeft <= tabRight) {
            var tabMid = (tabRight + tabLeft) / 2;
            if (target == tab[tabMid]) {
                return true;
            } else if (target < tab[tabMid]) {
                tabRight = tabMid - 1;
            } else {
                tabLeft = tabMid + 1;
            }
        }

        return false;
    }
}
