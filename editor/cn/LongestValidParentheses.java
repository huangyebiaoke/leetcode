//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1322 👎 0

import java.util.*;

//package leetcode.editor.cn;
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        int result=solution.longestValidParentheses("(()())");
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Stack<Character> stack=new Stack<Character>(){};
//        List<String> list=new ArrayList<>();
        public int longestValidParentheses(String s) {
            int result=0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)==')'){
                    continue;
                }
                for (int j = i; j < s.length(); j++) {
//                    System.out.print(j+": "+s.substring(i,j+1)+"\t"+stack);
                    if (s.charAt(j)=='('){
                        stack.push('(');
                    }else if (stack.isEmpty()){
                        break;
                    }else {
                        stack.pop();
                    }
                    if (stack.isEmpty()){
                        int temp=j-i+1;
                        if (temp>result){
                            result=temp;
                        }
                    }
//                    System.out.println("\t"+stack);
//                    if (stack.isEmpty()){
//                        list.add(s.substring(i,j+1));
////                        break;
//                    }
                }
                stack.clear();
            }
//            System.out.println(list);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}