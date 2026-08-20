class Solution {

    Map<Integer, Integer> mem = new HashMap<>();

    public int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n);
    }

    int dfs(int row, int col, int maxRow, int maxCol) {
        if (row == maxRow || col == maxCol) {
            return 0;
        }
        if (row == maxRow - 1 && col == maxCol - 1) {
            return 1;
        }
        var key = row * maxCol + col;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        var res = dfs(row + 1, col, maxRow, maxCol) + dfs(row, col + 1, maxRow, maxCol);
        mem.put(key, res);

        return res;
    }
}
