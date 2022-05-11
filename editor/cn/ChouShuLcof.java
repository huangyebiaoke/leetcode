//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 338 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        System.out.println(solution.nthUglyNumber(1690));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            if (n<6)
                return n;
            List<Integer> list=new ArrayList<>();
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            int m2idx=0;
            int m3idx=0;
            int m5idx=0;
            while (list.size()<n){
                int m=list.get(list.size()-1);
                while (m>=2*list.get(m2idx))
                    m2idx++;
                while (m>=3*list.get(m3idx))
                    m3idx++;
                while (m>=5*list.get(m5idx))
                    m5idx++;
                list.add(Math.min(Math.min(2*list.get(m2idx), 3*list.get(m3idx)),5*list.get(m5idx)));
            }
            return list.get(list.size()-2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}