//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 递归 数学 动态规划 👍 325 👎 0


public class OneNzhengShuZhong1chuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
        System.out.println(solution.countDigitOne(101));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int countDigitOne(String str) {
            if (str==null||str.isEmpty())
                return 0;
            int first=str.charAt(0)-'0';
            if (str.length()==1&&first==0)
                return 0;
            if (str.length()==1&&first>0)
                return 1;
            int numFist=0;
            if (first>1)
                numFist=(int)Math.pow(10,str.length()-1);
            else if (first==1)
                numFist=Integer.parseInt(str.substring(1))+1;
            int numOther=first*(str.length()-1)*(int)Math.pow(10,str.length()-2);
            int numRecursive=countDigitOne(str.substring(1));
            return numFist+numOther+numRecursive;
        }

        public int countDigitOne(int n) {
            return countDigitOne(String.valueOf(n));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}