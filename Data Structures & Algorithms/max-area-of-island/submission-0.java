class Solution {

    int maxRow = 0;
    int maxCol = 0;
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        maxRow = grid.length;
        maxCol = grid[0].length;
        int area = 0;

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (grid[row][col] == 1) {
                    dfs(grid, row, col);
                    area = Math.max(count, area);
                    count = 0;
                }
            }
        }

        return area;
    }

    void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row > maxRow - 1 ||
            col < 0 || col > maxCol - 1 || 
            grid[row][col] == 0){
                
            return;
        }

        grid[row][col] = 0;
        count++;

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
