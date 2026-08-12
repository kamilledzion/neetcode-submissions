class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        var maxRow = image.length;
        var maxCol = image[0].length;
        var origin = image[sr][sc];

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sr, sc});
    
        while (!queue.isEmpty()) {
            var value = queue.pollLast();
            var row = value[0];
            var col = value[1];

            if (image[row][col] == origin && image[row][col] != color) {
                image[row][col] = color;

                if (row + 1 >= 0 && row + 1 <= maxRow - 1) {
                    queue.add(new int[]{row + 1, col});
                }
                if (row - 1 >= 0 && row - 1 <= maxRow - 1) {
                    queue.add(new int[]{row - 1, col});
                }
                if (col + 1 >= 0 && col + 1 <= maxCol - 1) {
                    queue.add(new int[]{row, col + 1});
                }
                if (col - 1 >= 0 && col - 1 <= maxCol - 1) {
                    queue.add(new int[]{row, col - 1});
                }
            }
        }
        return image;

    }
}