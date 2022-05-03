//给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：n = 11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 312 👎 0


public class NthDigit {
    public static void main(String[] args) {
        Solution solution = new NthDigit().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        long countRange(int bit) {
            if (bit == 1) return 10;
            return 9 * bit * (long) Math.pow(10, bit - 1);
        }

        public int findNthDigit(int n) {
            if (n < 10)
                return n;
            int bit = 1;
            while (n >= countRange(bit))
                n -= countRange(bit++);
            return Long.toString((long) Math.pow(10, bit - 1) + n / bit).charAt(n % bit) - '0';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}