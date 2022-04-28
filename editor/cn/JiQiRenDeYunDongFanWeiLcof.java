//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 489 👎 0


public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        System.out.println(solution.movingCount(2,3,1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int getSum(int m, int n){
            return m%10+m%100/10+m%1000/100+n%10+n%100/10+n%1000/100;
        }

        boolean[][] visted;
        int moving(int x, int y,int m,int n, int k){
            if (x<0||x>m-1||y<0||y>n-1||visted[x][y]||getSum(x,y)>k)
                return 0;
            visted[x][y] = true;
            return 1+moving(x+1,y,m,n,k)+
                    moving(x-1,y,m,n,k)+
                    moving(x,y+1,m,n,k)+
                    moving(x,y-1,m,n,k);
        }

        public int movingCount(int m, int n, int k) {
            visted=new boolean[m][n];
            return moving(0,0,m,n,k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}