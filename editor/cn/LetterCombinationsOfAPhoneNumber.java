//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//

// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1323 👎 0

import java.util.ArrayList;
import java.util.List;

//package leetcode.editor.cn;
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("2"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();
        String[] strMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        void sub(String digits, int index, String temp) {
            if (index == digits.length()) {
//                System.out.println(temp);
                result.add(temp);
                return;
            }
            String letters= strMap[Integer.valueOf(digits.substring(index, index + 1))];
            for (int i = 0; i < letters.length(); i++) {
                sub(digits, index + 1, temp + letters.substring(i, i + 1));
            }
        }

        public List<String> letterCombinations(String digits) {
            if (digits.equals("")) {
                return result;
            }
            sub(digits, 0, "");
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}