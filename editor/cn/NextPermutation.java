//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//[1,3,2]
//[2,1,3]
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1137 👎 0

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//package leetcode.editor.cn;
public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] nums=new int[]{5,4,7,5,3,2};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        void swap(int[] arr,int i, int j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        void reverse(int[] arr,int i,int j){
            while(i<j){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
//        List<int[]> result=new ArrayList<>();
//        void permutation(int[] nums,int index){
//            if (index==nums.length){
//                result.add(nums);
//                return;
//            }
//            for (int i = index; i < nums.length; i++) {
//                swap(nums,i,index);
//                permutation(nums,index+1);
//                swap(nums,index,i);
//            }
//        }
        public void nextPermutation(int[] nums) {
            int i=0,j=0;
            for (i = nums.length-1; i > 0; i--) {
                if (nums[i-1]<nums[i]){
                    break;
                }
            }
            if (i-1>=0){
                for (j = nums.length-1; j > i-1; j--) {
                    if (nums[j]>nums[i-1]){
                        swap(nums,i-1,j);
                        reverse(nums,i,nums.length-1);
                        return;
                    }
                }
            }
            reverse(nums,0,nums.length-1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}