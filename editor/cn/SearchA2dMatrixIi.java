//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 分治 矩阵 👍 965 👎 0


public class SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi().new Solution();
        int[][] test1 = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[][] test2 = new int[][]{{-1, 3}};
        System.out.println(solution.searchMatrix(test2, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         *
         * @author huang
         * @date 2022/3/27 18:24
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            int col = 0;
            int row = matrix.length - 1;
            while (col < matrix[0].length && row >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                }else if (matrix[row][col] > target) {
                    row--;
                } else {
                    col++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}