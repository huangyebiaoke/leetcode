//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 389 👎 0

import java.util.HashMap;

public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
        int res=solution.integerBreak(10);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap memo=new HashMap<Integer,Integer>();
        public int integerBreak(int n) {
            if(memo.containsKey(n)){
                return (int) memo.get(n);
            }
            if(n<=1){
                return 1;
            }
            int res=Integer.MIN_VALUE;
            for (int i=1;i<n;i++){
                res=Integer.max(res,Integer.max(i*(n-i),i*integerBreak(n-i)));
            }
            memo.put(n,res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}