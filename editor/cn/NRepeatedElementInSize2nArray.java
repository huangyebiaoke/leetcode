//给你一个整数数组 nums ，该数组具有以下属性： 
//
// 
// 
// 
// nums.length == 2 * n. 
// nums 包含 n + 1 个 不同的 元素 
// nums 中恰有一个元素重复 n 次 
// 
//
// 找出并返回重复了 n 次的那个元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,3]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,1,2,5,3,2]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,1,5,2,5,3,5,4]
//输出：5
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 5000 
// nums.length == 2 * n 
// 0 <= nums[i] <= 10⁴ 
// nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次 
// 
// Related Topics 数组 哈希表 👍 123 👎 0


import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementInSize2nArray {
    public static void main(String[] args) {
        Solution solution = new NRepeatedElementInSize2nArray().new Solution();
        System.out.println(solution.repeatedNTimes(new int[]{1,2,3,3}));
        System.out.println(solution.repeatedNTimes(new int[]{2,1,2,5,3,2}));
        System.out.println(solution.repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int repeatedNTimes(int[] nums) {
            Set<Integer> set=new HashSet<>();
            for (int val : nums) {
                if (set.contains(val))
                    return val;
                else set.add(val);
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}