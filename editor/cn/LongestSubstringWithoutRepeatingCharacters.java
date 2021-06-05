  //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5401 👎 0

  import java.util.Collections;
  import java.util.Enumeration;
  import java.util.HashMap;
  import java.util.Hashtable;

  //package leetcode.editor.cn;
  public class LongestSubstringWithoutRepeatingCharacters{
      public static void main(String[] args) {
           Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
//          System.out.println(solution.lengthOfLongestSubstring("abca"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int head=0,tail=1;
        String str="";
        HashMap memo=new HashMap<String,Integer>();
//        System.out.println("s_len:"+s.length());
        while (tail!=s.length()+1){
            str=s.substring(head,tail);
            memo.put(str,str.length());
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
//                System.out.print("c:"+c+" ");
//                todo:不需要判断
                if(tail==s.length()){
                    break;
                }
                if(c==s.charAt(tail)){
                    head=s.indexOf(c,head)+1;
//                    System.out.print("head:"+head+" ");
                }
            }
//            System.out.println("\ntail"+tail+":"+s.charAt(tail));
            tail++;
        }
//        System.out.print(memo);
        return s.length()==0?0:(int)Collections.max(memo.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }