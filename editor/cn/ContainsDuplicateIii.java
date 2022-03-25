//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <=
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 104 
// 0 <= t <= 231 - 1 
// 
// Related Topics 数组 桶排序 有序集合 排序 滑动窗口 
// 👍 469 👎 0

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

//package leetcode.editor.cn;
public class ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{-2147483648,2147483647},1,1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//            int maxOfNums=nums[0];
//            for (int i = 1; i < nums.length; i++) {
//                if (nums[i]>maxOfNums){
//                    maxOfNums=nums[i];
//                }
//            }
//            int[] bucket=new int[maxOfNums];
//            for (int i = 0; i < nums.length; i++) {
//                bucket[nums[i]]++;
//            }
            System.out.println(BigInteger.valueOf(3).subtract(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(3)));
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j<nums.length && j <= i+k; j++) {
//                    Numeric Overflow
//                    -2147483648-2147483647=1
                  if (BigInteger.valueOf(nums[i]).subtract(BigInteger.valueOf(nums[j])).abs().compareTo(BigInteger.valueOf(t))==-1){
                      return true;
                  }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}