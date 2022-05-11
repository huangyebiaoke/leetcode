//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 422 👎 0


import java.util.HashMap;
import java.util.Map;

public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("aa"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max=0;
            Map<Character,Integer> map=new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
//                    如果扫描到的元素已经在之前的序列中，则从之前序列中重复元素的后一位重新计数
                    i=map.get(s.charAt(i))+1;
                    map.clear();
                }
                map.put(s.charAt(i),i);
                max=Math.max(map.size(),max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}