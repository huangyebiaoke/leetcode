//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 855 👎 0


import java.util.Collections;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        System.out.println(solution.findUnsortedSubarray(new int[]{1,2,3,4}));
        System.out.println(solution.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        System.out.println(solution.findUnsortedSubarray(new int[]{1}));
        System.out.println(solution.findUnsortedSubarray(new int[]{2,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean isSorted(int[] nums,int start,int end){
            if (start<0||end>=nums.length||end<start)
                throw new IllegalArgumentException("[start,end]: start>=0, end<nums.length");
            for (int i = start; i < end; i++) {
                if (nums[i+1]<nums[i])
                    return false;
            }
            return true;
        }

        boolean inSection(int[] nums,int start,int end){
            if (start<0||end>=nums.length||end<start)
                throw new IllegalArgumentException("[start,end]: start>=0, end<nums.length");
            for (int i = start+1; i < end; i++) {
                if (nums[i]<nums[start]||nums[i]>nums[end])
                    return false;
            }
            return true;
        }

        public int findUnsortedSubarray(int[] nums) {
            int min=nums[nums.length-1];
            int max=nums[0];
            int begin=0;
            int end=-1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]<max)
                    end=i;
                else max=nums[i];
                if (nums[nums.length-i-1]>min)
                    begin=nums.length-i-1;
                else min=nums[nums.length-i-1];
            }
            return end-begin+1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}