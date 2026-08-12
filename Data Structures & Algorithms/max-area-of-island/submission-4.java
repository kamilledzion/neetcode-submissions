class Solution {

    int maxRow = 0;
    int maxCol = 0;
    public int maxAreaOfIsland(int[][] grid) {
        maxRow = grid.length;
        maxCol = grid[0].length;
        int area = 0;

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (grid[row][col] == 1) {
                    var count = dfs(grid, row, col);
                    area = Math.max(count, area);
                }
            }
        }

        return area;
    }

    int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row > maxRow - 1 ||
            col < 0 || col > maxCol - 1 || 
            grid[row][col] == 0){
                
            return 0;
        }

        grid[row][col] = 0;
        int count = 1;
        
        count += dfs(grid, row + 1, col);
        count += dfs(grid, row - 1, col);
        count += dfs(grid, row, col + 1);
        count += dfs(grid, row, col - 1);

        return count;
    }
}
