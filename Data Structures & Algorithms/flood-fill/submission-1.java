class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        var maxRow = image.length;
        var maxCol = image[0].length;
        var origin = image[sr][sc];

        floodFill(image, sr, sc, color, origin, maxRow, maxCol);

        return image;
    }

    void floodFill(int[][] image, int sr, int sc, int color, int origin, int maxRow, int maxCol) {
        if (sr < 0 || sr > maxRow - 1  ||
            sc < 0 || sc > maxCol - 1) {
                return;
            }
        if (image[sr][sc] == color) {
            return;
        }
        if (image[sr][sc] != origin) {
            return;
        }
        image[sr][sc] = color;

        floodFill(image, sr + 1, sc, color, origin, maxRow, maxCol);
        floodFill(image, sr - 1, sc, color, origin, maxRow, maxCol);
        floodFill(image, sr, sc + 1, color, origin, maxRow, maxCol);
        floodFill(image, sr, sc - 1, color, origin, maxRow, maxCol);
    }
}