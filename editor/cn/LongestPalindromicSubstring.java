  //给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划
// 👍 3604 👎 0

  import java.util.Collections;
  import java.util.HashMap;
  import java.util.HashSet;

  //package leetcode.editor.cn;
  public class LongestPalindromicSubstring{
      public static void main(String[] args) {
           Solution solution = new LongestPalindromicSubstring().new Solution();
//           String str="cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
//          System.out.println(solution.longestPalindrome("babad"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
//      另一种解题思路,循环字符串一遍;在子函数中由中间向两边扩散,记录最小下标和最大下标;
class Solution {
    public String longestPalindrome(String s) {
        String stack="";
        String maxLengthStr="";
        for (int outCur = 0; outCur <= s.length(); outCur++) {
//            为了节省时间,找比最大回文字符串长度还长的子串
            for (int innerCur = outCur+maxLengthStr.length(); innerCur <= s.length(); innerCur++) {
//                System.out.println("outCur:"+outCur+" innerCur:"+innerCur);
                stack=s.substring(outCur,innerCur);
                Boolean isPalindrome=true;
                for (int i = 0; i < stack.length()/2; i++) {
//                    System.out.println(i);
                    if (stack.charAt(i)!=stack.charAt(stack.length()-i-1)){
                        isPalindrome=false;
                        break;
                    }
                }
                if (isPalindrome){
                    if (stack.length()>maxLengthStr.length()){
                        maxLengthStr=stack;
                    }
//                    System.out.println(stack);
                    stack="";
                }
            }
        }
        return maxLengthStr;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }