//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 👍 320 👎 0


import java.util.Arrays;

public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
//        System.out.println(solution.singleNumber(new int[]{3,3,3,4}));
        System.out.println(solution.singleNumber(new int[]{9,1,7,9,7,9,7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int[] bitsReverse=new int[32];
            for (int num : nums) {
//                System.out.println(Integer.toBinaryString(nums[i]));
                for (int j = 0; j < bitsReverse.length; j++) {
                    bitsReverse[j] += (num >> j) & 1;
                }
            }
//            System.out.println(Arrays.toString(bitsReverse));
            int res=0;
            for (int i = bitsReverse.length-1; i>=0; i--) {
//                System.out.println(Integer.toBinaryString(res));
                res<<=1;
                res+=bitsReverse[i]%3;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}