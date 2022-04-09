//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。 
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
//
//[1,4,4,2,4]
//[2,2,2,2,2]
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
// Related Topics 位运算 数组 双指针 二分查找 👍 1641 👎 0


import java.util.HashSet;

public class FindTheDuplicateNumber{
    public static void main(String[] args) {
       Solution solution = new FindTheDuplicateNumber().new Solution();
       int[] a=new int[]{1,4,4,2,4};
        System.out.println(solution.findDuplicate(a));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
//        int res=0;
//        for (int i = 0; i < nums.length; i++) {
//            res=res^i^nums[i];
//        }
//        return res;
        HashSet<Integer> bucket=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!bucket.contains(nums[i])){
                bucket.add(nums[i]);
            }else {
                return nums[i];
            }
        }
        return -1;
    }
//    int countRange(int[] arr, int low, int high){
//        int count=0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i]>=low && arr[i]<=high){
//                count++;
//            }
//        }
//        return count;
//    }
//    public int findDuplicate(int[] nums) {
//        if (nums==null&&nums.length==0){
//            return -1;
//        }
//        int low = 1;
//        int high = nums.length-1;
//        while (low <= high) {
////            System.out.println(low+" "+high);
//            int mid = (low + high) >>> 1;
//            int count=countRange(nums,low,mid);
//            if (low==high){
//                if (count>1){
//                    return low;
//                }else {
//                    break;
//                }
//            }
//            if (count > mid-low+1){
//                high = mid;
//            }else{
//                low = mid+1;
//            }
//        }
//        return -1;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}