class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        var maxRow = image.length;
        var maxCol = image[0].length;
        var origin = image[sr][sc];

        return floodFill(image, sr, sc, color, origin, maxRow, maxCol, new int[maxRow][maxCol]);
    }

    int[][] floodFill(int[][] image, int sr, int sc, int color, int origin, int maxRow, int maxCol, int[][] visited) {
        if (sr < 0 || sr > maxRow - 1  ||
            sc < 0 || sc > maxCol - 1) {
                return image;
            }
        if (visited[sr][sc] == 1) {
            return image;
        }
        if (image[sr][sc] != origin) {
            return image;
        }
        image[sr][sc] = color;
        visited[sr][sc] = 1;

        floodFill(image, sr + 1, sc, color, origin, maxRow, maxCol, visited);
        floodFill(image, sr - 1, sc, color, origin, maxRow, maxCol, visited);
        floodFill(image, sr, sc + 1, color, origin, maxRow, maxCol, visited);
        floodFill(image, sr, sc - 1, color, origin, maxRow, maxCol, visited);

        return image;
    }
}