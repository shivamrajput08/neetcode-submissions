class Solution {
    int m, n, l;
    int[][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    private boolean find(char[][] board, int i, int j, String word, int idx) {
        if (idx == l) return true;

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        for (int[] dir : direction) {
            if (find(board, i + dir[0], j + dir[1], word, idx + 1)) {
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        l = word.length();

        if (l == 0) return true;
        if (m * n < l) return false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (find(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
