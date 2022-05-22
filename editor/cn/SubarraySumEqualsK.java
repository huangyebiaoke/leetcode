//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1486 👎 0


import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{1,1,1},2));
        System.out.println(solution.subarraySum(new int[]{1,2,3},3));
        System.out.println(solution.subarraySum(new int[]{-1,-1,1},0));
        System.out.println(solution.subarraySum(new int[]{1,-1,0},0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count=0;
            int sum=0;
            HashMap<Integer,Integer> map=new HashMap<>();
            for (int num : nums) {
//                计算前缀和
                sum += num;
                if (sum == k)
                    count++;
                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}