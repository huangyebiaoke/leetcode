//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1801 👎 0

import java.util.*;

//package leetcode.editor.cn;
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result=new ArrayList<>();
        List<String> memo=new ArrayList<>();
        void sub(int n,String str){
            if (memo.contains(str)){
                return;
            }
            if (str.length()==2*n){
                if (!result.contains(str)){
                    result.add(str);
                }
                return;
            }
            for (int i = 0; i <= str.length(); i++) {
                String temp=str.substring(0,i)+"()"+str.substring(i);
                sub(n,temp);
                memo.add(temp);
            }
        }

        public List<String> generateParenthesis(int n) {
            sub(n,"");
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}