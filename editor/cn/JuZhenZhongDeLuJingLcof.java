//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 573 👎 0


public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCED";
        System.out.println(solution.exist(board,word));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;

        boolean sub(char[][] board, String word, int row, int col, int strLen) {
            if (strLen==word.length()) {
                return true;
            }
            boolean hasNext=false;
            if (row < board.length && row >= 0 && col < board[0].length && col >= 0&&!visited[row][col]&&word.charAt(strLen) == board[row][col]) {
                ++strLen;
                visited[row][col]=true;
                hasNext=sub(board, word, row - 1, col, strLen)||
                        sub(board, word, row + 1, col, strLen)||
                        sub(board, word, row, col-1, strLen)||
                        sub(board, word, row, col+1, strLen);
                if (!hasNext) {
                    --strLen;
                    visited[row][col]=false;
                }
            }
            return hasNext;
        }

        public boolean exist(char[][] board, String word) {
            visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (word.charAt(0) == board[i][j]&&sub(board, word, i, j, 0))
                        return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}