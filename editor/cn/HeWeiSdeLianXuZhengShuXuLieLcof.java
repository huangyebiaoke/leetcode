//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 👍 433 👎 0


import java.util.LinkedList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        System.out.println(solution.findContinuousSequence(100000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> ans=new LinkedList<>();
            int low=1,high=2;
            while (low<high&&high<=target/2+1){
                int sum=(low+high)*(high-low+1)/2;
                if (sum<target)
                    high++;
                else if (sum>target)
                    low++;
                else {
                    int[] sub=new int[high-low+1];
                    for (int i = 0; i < sub.length; i++)
                        sub[i]=low+i;
                    ans.add(sub);
                    high++;
                }
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}