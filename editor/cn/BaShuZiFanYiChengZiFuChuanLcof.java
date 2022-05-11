//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 428 👎 0


import java.util.Arrays;

public class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        System.out.println(solution.translateNum(12258));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            if (num<10)
                return 1;
            String str=String.valueOf(num);
            int[] f=new int[str.length()];
            f[f.length-1]=1;
            f[f.length-2]=1+ifInRange(f.length-2, str)*f[f.length-1];
//            1.这个DP问题是对称的，不存在自下而上；2.可以用a，b两个临时遍变量做滚动数组；
            for (int i = str.length()-1; i >= 2; i--)
                f[i-2]=f[i-1]+ifInRange(i-2,str)*f[i];
//            System.out.println(Arrays.toString(f));
            return f[0];
        }

        private int ifInRange(int i, String str) {
//            System.out.println(str.substring(i,i+2));
            if (str.charAt(i)=='0')
                return 0;
            int num=Integer.parseInt(str.substring(i,i+2));
            return num>=0&&num<=25?1:0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}