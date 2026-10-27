class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = board[0].length;
        Set<Character>[] rows = new Set[size];
        Set<Character>[] cols = new Set[size];
        Set<Character>[] box = new Set[size];

        for (int r = 0; r < size; r++) {
            if (rows[r] == null) {
                rows[r] = new HashSet<>();
            }
            for (int c = 0; c < size; c++) {
                if (cols[c] == null) {
                    cols[c] = new HashSet<>();
                }
                int index = (r / 3) * 3 + (c / 3);
                if (box[index] == null) {
                    box[index] = new HashSet<>();
                }

                Character val = board[r][c];
                if (val == '.') {
                    continue;
                }

                if (rows[r].contains(val) || cols[c].contains(val) || box[index].contains(val)) {
                    return false;
                }
                rows[r].add(val);
                cols[c].add(val);
                box[index].add(val);
            }
        }

        return true;
    }
}
