//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 879 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

//package leetcode.editor.cn;
public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        int res = solution.coinChange(new int[]{1, 2, 3,4,5,6,7,8,9}, 10);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    import java.util.HashMap;
    class Solution {
//        HashMap要比Hashtable快100ms左右，因为Hashtable内部方法是synchronized保证线程安全，而HashMap则没有
//        要符合「最优子结构」，子问题间必须互相独立
//        动态规划问题：明确 base case -> 明确「状态」（变量）-> 明确「选择」（导致状态产生变化的行为，写出状态转移方程） -> 定义 dp 数组/函数的含义（输入目标金额，输出凑出目标金额最少的数量）
        HashMap memo=new HashMap<Integer,Integer>();
        public int coinChange(int[] coins, int amount) {
//            缓存的结果直接返回，避免重复计算
            if (memo.containsKey(amount)){
                return (int) memo.get(amount);
            }
//            base case
            if (amount == 0) {
                return 0;
            } else if (amount < 0) {
                return -1;
            }
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                int subProblem = coinChange(coins, amount - coin);
                if (subProblem == -1) {
                    continue;
                }
//                状态转移方程：dp(amount)=1+min(dp(amount-coin)...)
                res = Integer.min(res, 1 + subProblem);
            }
//            剪枝
            memo.put(amount,res!= Integer.MAX_VALUE ? res : -1);
            return (int) memo.get(amount);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}