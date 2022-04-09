//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ ）。 
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
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xⁿ <= 104 
// 
// Related Topics 递归 数学 👍 925 👎 0


public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
//      System.out.println(solution.myPow(1.00000,2147483647));
        System.out.println(solution.myPow(2.00000, -2147483648));
//      System.out.println(solution.myPow(0,10));
//      System.out.println(solution.myPow(2,-2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n < 0) {
                x = 1.0 / x;
                n = -n;
//        -(-2147483648)=-2147483648
                if (n == Integer.MIN_VALUE)
                    n = -(n + 2);
            }
            double res = 1.0;
            while (n >= 1) {
                if ((n & 1) == 1) {
                    res *= x;
                }
                x = x * x;
                n >>= 1;
            }
            return res;
        }

//      public double myPow(double x, int n) {
//          if (x==1.0)
//              return 1.0;
//          else if (x==-1.0){
//              if (n%2==0)
//                  return 1.0;
//              else
//                  return -1.0;
//          }
//          if (n==-2147483648)
//              return 0.0;
//          double res=1.0;
//          int n_abs=Math.abs(n);
//          for (int i = 0; i < n_abs; i++) {
//              res*=x;
//          }
//          if (n<0)
//              res=1.0/res;
//          return res;
//      }

    }
//leetcode submit region end(Prohibit modification and deletion)

}