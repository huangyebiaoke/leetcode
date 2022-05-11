//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 310 👎 0


import java.util.Arrays;
import java.util.Collections;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        System.out.println(solution.search(new int[]{1,2,2},1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int right(int[] a, int key) {
            int low = 0, high = a.length - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (a[mid] <= key)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return low;
        }

        public int search(int[] nums, int target) {
            return right(nums,target)-right(nums,target-1);
//            int index= Arrays.binarySearch(nums,target);
//            if (index<0)
//                return 0;
//            int i=index,j=index;
//            int count=1;
//            while (--i>=0&&nums[i]==target)
//                count++;
//            while (++j<nums.length&&nums[j]==target)
//                count++;
//            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}