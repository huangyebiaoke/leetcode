//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2⁻² = 1/2² = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 数学 👍 289 👎 0


public class ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
//        System.out.println(solution.myPow(3,4));
//        System.out.println(solution.myPow(2,-2));
        System.out.println(solution.myPow(2.00000,-2147483648));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        double pow(double x, int n){
            if (n == 0)
                return 1;
            if (n == 1)
                return x;
            double res = myPow(x, n >> 1);
            res *= res;
            if ((n & 1) == 1)
                res *= x;
            return res;
        }

        public double myPow(double x, int n) {
            if (n<0){
                n=-n;
                x=1.0/x;
                if (n == Integer.MIN_VALUE)
                    n = -(n + 2);
            }
            return pow(x,n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}