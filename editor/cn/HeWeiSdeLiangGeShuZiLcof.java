//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// Related Topics 数组 双指针 二分查找 👍 184 👎 0


import java.util.Arrays;

public class HeWeiSdeLiangGeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLiangGeShuZiLcof().new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2,7,11,15},9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{10,26,30,31,47,60},40)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{18,19,25,30,39,41,61,77,88,97},59)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int low=0,high=nums.length-1;
            while (low<high){
//                为避免溢出可以用减法
                if (nums[low]+nums[high]>target)
                    high--;
                else if (nums[low]+nums[high]<target)
                    low++;
                else return new int[]{nums[low],nums[high]};
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}