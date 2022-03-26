//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
// Related Topics 数组 数学 矩阵 👍 1219 👎 0


import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        int[][] test1=new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] test2=new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7},{15,14,12,16}};
        solution.rotate(test2);
        for (int i = 0; i < test2.length; i++) {
            System.out.println(Arrays.toString(test2[i]));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void swap(int[][] arr, int i, int j, int m, int n){
            arr[i][j]=arr[i][j]^arr[m][n];
            arr[m][n]=arr[i][j]^arr[m][n];
            arr[i][j]=arr[i][j]^arr[m][n];
        }
        public void rotate(int[][] matrix) {
            int n=matrix.length;
            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < n; j++) {
                    swap(matrix,i,j,n-i-1,j);
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    swap(matrix,i,j,j,i);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}