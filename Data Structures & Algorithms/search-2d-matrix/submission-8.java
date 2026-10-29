class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        int left = 0;
        int right = rowSize * colSize - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / colSize;
            int col = mid % colSize;
            if (matrix[row][col] > target) {
                right = mid - 1;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
