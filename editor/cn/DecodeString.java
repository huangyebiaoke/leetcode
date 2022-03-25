//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// s 由小写英文字母、数字和方括号 '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为 [1, 300] 
// 
// Related Topics 栈 递归 字符串 👍 1076 👎 0


//package leetcode.editor.cn;
public class DecodeString{
  public static void main(String[] args) {
       Solution solution = new DecodeString().new Solution();
       String s = "3[a]2[bc]";
       String s2 = "3[a2[c]]";
       String s3 = "2[abc]3[cd]ef";
       String s4 = "abc3[cd]xyz";
       String s5 = "100[leetcode]";
       String s6 = "2[20[bc]31[xy]]xd4[rt]";
       String s7="3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
      System.out.println(solution.decodeString(s7));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
//        获取左括号和右括号的位置；
//        System.out.println(s);
        int p=0,q=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='['){
                p=i;
            }
        }
        for (int i = s.length()-1; i > p; i--) {
//            System.out.println("p:"+p+" q:"+i);
            if (s.charAt(i)==']'){
                q=i;
            }
        }
//        递归终止条件；
        if (p==0&&q==0){
            return s;
        }
//        获取数字部分，数字范围[1,300]，所以只要从左括号往左检查三位即可；
        int intLen=1;
        int val=Integer.parseInt(s.substring(p-1,p));
        if (p-2>=0&&Character.isDigit(s.charAt(p-2))){
            intLen=2;
            val=Integer.parseInt(s.substring(p-2,p));
            if (p-3>=0&&Character.isDigit(s.charAt(p-3))){
                intLen=3;
                val=Integer.parseInt(s.substring(p-3,p));
            }
        }
//        解码
        String temp="";
        for (int i = 0; i < val; i++) {
            temp+=s.substring(p+1,q);
        }
//        将解码最内层或者最右的数字括号部分递归
//        System.out.println("0-p:"+s.substring(0,p-intLen)+" temp:"+temp+" q:"+s.substring(q+1));
        return decodeString(s.substring(0,p-intLen)+temp+s.substring(q+1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}