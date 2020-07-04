/**
编写扫雷，主要是根据周围雷的数量，算出自己的数字，如果自己是Blank，则要用dfs揭露相邻的方块，比较容易
*/
class Solution {
    int row;
    int col;
    Set<Integer> visited = new HashSet<>();

    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }
        row = board.length;
        col = board[0].length;
        dfs(i, j, board);
        return board;
    }

    void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return;
        }
        int curr = i * col + j;
        if (!visited.contains(curr)) {
            visited.add(curr);
            int cnt = count(i, j, board);
            if (cnt > 0) {
                board[i][j] = String.valueOf(cnt).charAt(0);
                return;
            }
            board[i][j] = 'B';
            dfs(i - 1, j, board);
            dfs(i - 1, j - 1, board);
            dfs(i, j - 1, board);
            dfs(i + 1, j - 1, board);
            dfs(i + 1, j, board);
            dfs(i + 1, j + 1, board);
            dfs(i, j + 1, board);
            dfs(i - 1, j + 1, board);
        }

    }

    int count(int r, int c, char[][] board) {
        int res = 0;
        if (r > 0 && board[r - 1][c] == 'M') {
            res++;
        }
        if (r > 0 && c > 0 && board[r - 1][c - 1] == 'M') {
            res++;
        }
        if (c > 0 && board[r][c - 1] == 'M') {
            res++;
        }
        if (r + 1 < row && c > 0 && board[r + 1][c - 1] == 'M') {
            res++;
        }
        if (r + 1 < row && board[r + 1][c] == 'M') {
            res++;
        }
        if (r + 1 < row && c + 1 < col && board[r + 1][c + 1] == 'M') {
            res++;
        }
        if (c + 1 < col && board[r][c + 1] == 'M') {
            res++;
        }
        if (r > 0 && c + 1 < col && board[r - 1][c + 1] == 'M') {
            res++;
        }
        return res;
    }
}