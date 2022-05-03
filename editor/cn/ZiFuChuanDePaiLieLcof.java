//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 546 👎 0


import java.util.HashSet;
import java.util.Set;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        solution.permutation("abc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Set<String> set =new HashSet<>();
        public String[] permutation(String s) {
            char[] chars=s.toCharArray();
            sub(chars,0);
            return set.toArray(new String[0]);
        }

        void swap(char[] chars,int i,int j){
            char tmp=chars[i];
            chars[i]=chars[j];
            chars[j]=tmp;
        }
        private void sub(char[] chars, int i) {
            if (i==chars.length-1){
                set.add(String.copyValueOf(chars));
                return;
            }
            for (int j = i; j < chars.length; j++) {
                swap(chars,i,j);
                sub(chars,i+1);
                swap(chars,i,j);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}