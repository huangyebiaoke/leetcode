//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1603 👎 0


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        String s="leetcode";
        List<String> wordDict= Arrays.asList("leet","code");
        System.out.println(solution.wordBreak(s,wordDict));
        String s2="applepenapple";
        List<String> wordDict2= Arrays.asList("apple", "pen");
        System.out.println(solution.wordBreak(s2,wordDict2));
        String s3="catsandog";
        List<String> wordDict3= Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(solution.wordBreak(s3,wordDict3));
        String s4="abcd";
        List<String> wordDict4= Arrays.asList("a","abc","b","cd");
        System.out.println(solution.wordBreak(s4,wordDict4));
        String s5="aaaaaaa";
        List<String> wordDict5= Arrays.asList("aaaa","aa");
        System.out.println(solution.wordBreak(s5,wordDict5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Trie{
            private Trie[] next;
            private boolean isEnd;
            public Trie(){
                next=new Trie[26];
                isEnd=false;
            }
            void create(List<String> wordDict) {
                Trie cur=this;
                for (String word : wordDict) {
                    for (int i = 0; i < word.length(); i++) {
                        if (cur.next[word.charAt(i)-'a']==null)
                            cur.next[word.charAt(i)-'a']=new Trie();
                        cur=cur.next[word.charAt(i)-'a'];
                    }
                    cur.isEnd=true;
                    cur=this;
                }
            }

            boolean contains(String s){
                Trie cur=this;
                for (int i = 0; i < s.length(); i++) {
                    if (cur.next[s.charAt(i)-'a']==null)
                        return false;
                    cur=cur.next[s.charAt(i)-'a'];
                    if (i==s.length()-1&&cur.isEnd)
                        return true;
                }
                return false;
            }
        }

        boolean[] memo;
        Trie root;
        boolean dfs(String s, int start){
            if (memo[start]) return false;
            if (start==s.length()) return true;
            Trie cur=root;
            for (int i = start; i < s.length(); i++) {
                if (cur.next[s.charAt(i)-'a']!=null){
                    cur=cur.next[s.charAt(i)-'a'];
                    if (cur.isEnd&&dfs(s,i+1))
                        return true;
                }else break;
            }
            memo[start]=true;
            return false;
        }
        public boolean wordBreak(String s, List<String> wordDict) {
//            初始化字典树;
            root=new Trie();
            root.create(wordDict);
//            dfs
            memo=new boolean[301];
            return dfs(s,0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}