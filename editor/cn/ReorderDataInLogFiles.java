//给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。 
//
// 有两种不同类型的日志： 
//
// 
// 字母日志：除标识符之外，所有字均由小写字母组成 
// 数字日志：除标识符之外，所有字均由数字组成 
// 
//
// 请按下述规则将日志重新排序： 
//
// 
// 所有 字母日志 都排在 数字日志 之前。 
// 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。 
// 数字日志 应该保留原来的相对顺序。 
// 
//
// 返回日志的最终顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 
//art zero"]
//输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6
//"]
//解释：
//字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
//数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
// 
//
// 示例 2： 
//
// 
//输入：logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
//
//输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= logs.length <= 100 
// 3 <= logs[i].length <= 100 
// logs[i] 中，字与字之间都用 单个 空格分隔 
// 题目数据保证 logs[i] 都有一个标识符，并且在标识符之后至少存在一个字 
// 
// Related Topics 数组 字符串 排序 👍 147 👎 0


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ReorderDataInLogFiles {
    public static void main(String[] args) {
        Solution solution = new ReorderDataInLogFiles().new Solution();
//        System.out.println(Arrays.toString(solution.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})));
//        System.out.println(Arrays.toString(solution.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
//        System.out.println(Arrays.toString(solution.reorderLogFiles(new String[]{"7 so","t kvr","r 3 1","i 403","t 54"})));
//        System.out.println(Arrays.toString(solution.reorderLogFiles(new String[]{"j mo", "5 m w", "g 07", "o 2 0", "t q h"})));
//        期望结果:["5 m w","j mo","t q h","g 07","o 2 0"]
//        System.out.println(Arrays.toString(solution.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"})));
//        期望结果:["a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
//        System.out.println("t q h".replaceFirst("(\\D*)(\\d*)\\s",""));
        System.out.println(Arrays.toString(solution.reorderLogFiles(new String[]{"zoey i love you","lucas i love you","rong i love you"})));
//        期望结果:["lucas i love you","rong i love you","zoey i love you"]
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            Arrays.sort(logs, (o1, o2) -> {
                boolean isLetter1=Character.isLetter(o1.charAt(o1.length()-1));
                boolean isLetter2=Character.isLetter(o2.charAt(o2.length()-1));
                if (isLetter1 || isLetter2){
                    if (!isLetter1)
                        return 1;
                    if (!isLetter2)
                        return -1;
                    int a=o1.indexOf(" "),b=o2.indexOf(" ");
                    String tmp1=o1.substring(a+1),tmp2=o2.substring(b+1);
                    if (tmp1.equals(tmp2)){
                        tmp1=o1.substring(0,a);
                        tmp2=o2.substring(0,b);
                    }
                    return String.CASE_INSENSITIVE_ORDER.compare(tmp1,tmp2);
                }else return 0;
            });
            return logs;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}