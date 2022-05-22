//给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。 
//
// 
//示例:
//输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//输出: 2
//解释: 
//这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
// 
//
// 
//
// 注意: 
//
// 
// 3 <= points.length <= 50. 
// 不存在重复的点。 
// -50 <= points[i][j] <= 50. 
// 结果误差值在 10^-6 以内都认为是正确答案。 
// 
// Related Topics 几何 数组 数学 👍 165 👎 0


public class LargestTriangleArea {
    public static void main(String[] args) {
        Solution solution = new LargestTriangleArea().new Solution();
//        int[][] points=new int[][]{
//                {0,0},
//                {0,1},
//                {1,0},
//                {0,2},
//                {2,0}
//        };
//        System.out.println(solution.largestTriangleArea(points));
        int[][] points2=new int[][]{
                {-35,19},{40,19},{27,-20},{35,-3},{44,20},{22,-21},{35,33},{-19,42},{11,47},{11,37}
        };
        System.out.println(solution.largestTriangleArea(points2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double largestTriangleArea(int[][] points) {
            double ans=0;
            for (int[] i : points) {
                for (int[] j : points) {
                    if (i==j)
                        continue;
                    for (int[] k : points) {
                        if (j==k)
                            continue;
                        double s=0.5*Math.abs(i[0]*(j[1]-k[1])+j[0]*(k[1]-i[1])+k[0]*(i[1]-j[1]));
                        ans=Math.max(s,ans);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}