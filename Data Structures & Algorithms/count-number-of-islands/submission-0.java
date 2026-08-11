class Solution {
    
    int maxRow;
    int maxCol;
    public int numIslands(char[][] grid) {
        maxRow = grid.length;
        maxCol = grid[0].length;

        var count = 0;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                count += dfs(grid, row, col);
            }
        }
        return count;
    }

    int dfs(char[][] grid, int row, int col) {
        if (row < 0 || row > maxRow - 1 ||
            col < 0 || col > maxCol - 1) {
            return 0;
        }

        if (grid[row][col] == '0' || grid[row][col] == 'x') {
            return 0;
        } 
        grid[row][col] = 'x';

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);

        return 1;
    }    
}
