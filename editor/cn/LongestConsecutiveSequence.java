//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 1257 👎 0


import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(solution.longestConsecutive(new int[]{0,-1}));
        System.out.println(solution.longestConsecutive(new int[]{0,1,2,4,8,5,6,7,9,3,55,88,77,99,999999999}));
        System.out.println(solution.longestConsecutive(new int[]{-8,-4,9,9,4,6,1,-4,-1,6,8}));
        System.out.println(solution.longestConsecutive(new int[]{1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set=new HashSet<>();
            for (int val : nums)
                set.add(val);
            int ans=0;
            for (int val : set) {
//                找到连续区间的最左边
                if (!set.contains(val-1)){
                    int tmp=val;
                    int len=1;
                    while (set.contains(tmp+1)){
                        len++;
                        tmp++;
                    }
                    ans=Math.max(ans,len);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}