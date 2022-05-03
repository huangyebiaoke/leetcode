//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 二分查找 👍 244 👎 0


public class ShuZiXuLieZhongMouYiWeiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        System.out.println(solution.findNthDigit(1000000000));
//        期望结果:1
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        计算bit位数范围内的数的长度；
        long countRange(int bit){
            if (bit==1) return 10;
            return 9*bit*(long)Math.pow(10,bit-1);
        }
        public int findNthDigit(int n) {
            if (n<10)
                return n;
            int bit=1;
            while (n>=countRange(bit))
                n-=countRange(bit++);
            return String.valueOf((long)Math.pow(10,bit-1)+n/bit).charAt(n%bit)-'0';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}