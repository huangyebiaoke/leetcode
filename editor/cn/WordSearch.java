//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
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
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1301 👎 0


public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        char[][] board=new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word="ABCCED";
        System.out.println(solution.exist(board,word));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean exist(char[][] board, String word,boolean[][] visited,int x,int y){
            if (word.length()==0)
                return true;
            if (x<0||x>=board.length||y<0||y>=board[0].length||visited[x][y]||board[x][y]!=word.charAt(0))
                return false;
            visited[x][y] = true;
            boolean flag = exist(board, word.substring(1), visited, x - 1, y) ||
                    exist(board, word.substring(1), visited, x + 1, y) ||
                    exist(board, word.substring(1), visited, x, y + 1) ||
                    exist(board, word.substring(1), visited, x, y - 1);
            if (!flag)
                visited[x][y] = false;
            return flag;
        }


        public boolean exist(char[][] board, String word) {
            boolean[][] visited=new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j]==word.charAt(0)&&exist(board,word,visited,i,j)){
                            return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}