//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2417 👎 0

import javax.sound.midi.SoundbankResource;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//package leetcode.editor.cn;
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("(){}}{"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Stack<Character> stack=new Stack<Character>(){{push('?');}};
        Map<Character,Character> dict=new HashMap<Character,Character>(){
            {
                put('[',']');
                put('{','}');
                put('(',')');
            }
        };
        public boolean isValid(String s) {
            if (s.length()>0&&!dict.containsKey(s.charAt(0))){
                return false;
            }
            for (Character c: s.toCharArray()) {
                if (dict.containsKey(c)){
                    stack.push(c);
                }else {
                    Character tempC=stack.pop();
                    if (!c.equals(dict.get(tempC))){
                        return false;
                    }
                }
            }
            return stack.size()==1;
//            int len=s.length();
//            for (int i = 0; i < len/2; i++) {
//                s=s.replace("()","");
//                s=s.replace("{}","");
//                s=s.replace("[]","");
//            }
//            return s.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}