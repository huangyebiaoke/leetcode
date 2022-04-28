//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 391 👎 0


import java.util.Arrays;

public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(solution.spiralOrder(new int[][]{})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix==null||matrix.length==0||matrix[0].length==0)
                return new int[0];
            int cols = matrix[0].length, rows = matrix.length;
            int[] ans = new int[rows * cols];
            boolean[][] visited = new boolean[rows][cols];
            int row = 0, col = 0;
            int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIndex = 0;
            for (int k = 0; k < ans.length; k++) {
                ans[k] = matrix[row][col];
                visited[row][col] = true;
                int nextRow =row+direction[directionIndex][0], nextCol = col+direction[directionIndex][1];
                if (nextRow >= rows || nextRow < 0 || nextCol >= cols || nextCol < 0 || visited[nextRow][nextCol])
                    directionIndex = (directionIndex + 1) % 4;
                row += direction[directionIndex][0];
                col += direction[directionIndex][1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}