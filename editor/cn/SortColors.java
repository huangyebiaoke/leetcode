//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库的sort函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 👍 1229 👎 0


import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        int[] test1 = new int[]{2, 0, 2, 1, 1, 0};
        int[] test2 = new int[]{2, 0, 1};
        solution.sortColors(test2);
        System.out.println(Arrays.toString(test2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

//        O(n)
        private void threeWayPartition(int[] arr, int mid) {
            int lo = 0, i = 0, hi = arr.length - 1;
            while (i <= hi) {
//                System.out.println(Arrays.toString(arr));
                if (arr[i] < mid) {
                    swap(arr, lo++, i++);
                } else if (arr[i] > mid) {
                    swap(arr, i, hi--);
                } else {
                    i++;
                }
            }
        }

        public void sortColors(int[] nums) {
//            threeWayPartition(nums, 1);
//            O(2n) int[]数组"24+4N"字节
            int[] sum=new int[3];
            for (int num : nums) {
                sum[num]++;
            }
            int temp=0;
            for (int i = 0; i < sum.length; i++) {
                for (int j = temp; j < temp+sum[i]; j++) {
                    nums[j]=i;
                }
                temp+=sum[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}