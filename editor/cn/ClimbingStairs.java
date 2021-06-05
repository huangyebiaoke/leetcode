//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1297 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//package leetcode.editor.cn;
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        int sum=solution.climbStairs(47);
        System.out.println(sum);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
//            input->48; output->-811192543;
//            知道二叉树的最大深度->求解二叉树的叶子节点个数
//            类似求斐波那契数列
            HashMap dp=new HashMap<Integer,Integer>();
            dp.put(1,1);
            dp.put(2,2);
            for (int i=3;i<=n;i++){
                int temp=(int)dp.get(i-1)+(int)dp.get(i-2);
                dp.put(i,temp);
            }
            return (int)dp.get(n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}