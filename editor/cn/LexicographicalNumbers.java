//给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。 
//
// 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5 * 10⁴ 
// 
// Related Topics 深度优先搜索 字典树 👍 272 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicalNumbers {
    public static void main(String[] args) {
        Solution solution = new LexicographicalNumbers().new Solution();
        System.out.println(solution.lexicalOrder(144));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        void dfs(int i, int n){
            if (i>n)
                return;
            list.add(i);
            for (int j = 0; j < 10; j++) {
                dfs(i*10+j,n);
            }
        }

        List<Integer> list=new ArrayList<>();
        public List<Integer> lexicalOrder(int n) {
            for (int i = 1; i < 10; i++) {
                dfs(i,n);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}