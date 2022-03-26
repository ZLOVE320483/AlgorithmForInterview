/**
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 

 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 

 
 
 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 

 

 示例 1： 

 
输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。
 

 示例 2： 

 
输入：n = 1
输出：[["Q"]]
 

 

 提示： 

 
 1 <= n <= 9 
 
 
 
 Related Topics 数组 回溯 👍 1238 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<String>> result = new LinkedList();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        backTracking(board, 0);
        return result;
    }

    private void backTracking(char[][] board, int row) {
        if (row == board.length) {
            convertToList(board);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backTracking(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void convertToList(char[][] board) {
        List<String> ss = new LinkedList();
        for (char[] array : board) {
            StringBuilder builder = new StringBuilder();
            for (char item : array) {
                builder.append(item);
            }
            ss.add(builder.toString());
        }
        result.add(ss);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
