//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 👍 216 👎 0


import java.util.Arrays;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
//        System.out.println(Arrays.toString(solution.exchange(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(solution.exchange(new int[]{2, 2, 3, 4, 3, 3, 2})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                if ((nums[i] & 1) == 1)
                    i++;
                else if ((nums[j] & 1) != 1)
                    j--;
                else {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}