//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 👍 1133 👎 0


import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        List<List<String>> lists=solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        private String hashCode(String str){
//            int[] bucket=new int[26];
//            for (int i = 0; i < str.length(); i++) {
//                bucket[str.charAt(i)-'a']++;
//            }
//            StringBuilder sb=new StringBuilder();
//            for (int i = 0; i < bucket.length; i++) {
//                while (bucket[i]>0){
//                    sb.append((char)(i+'a'));
//                    bucket[i]--;
//                }
//            }
//            return sb.toString();
//        }
        private int hashCode(String str){
            int key=0;
            for (int i = 0; i < str.length(); i++) {
                key+=str.charAt(i)*str.charAt(i)*str.charAt(i)*str.charAt(i);
            }
            return key;
        }
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<Integer,List<String>> hashMap=new HashMap<>();
            for (String str : strs) {
//                难点: 同一字符串的不同排列的hashCode要一致
                int key=hashCode(str);
                List<String> list=hashMap.getOrDefault(key,new ArrayList<>());
                list.add(str);
                hashMap.put(key,list);
            }
            return new ArrayList<>(hashMap.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}