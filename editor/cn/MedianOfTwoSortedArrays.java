  //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 4052 👎 0

  import java.util.Arrays;

  //package leetcode.editor.cn;
  public class MedianOfTwoSortedArrays{
      public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
//          int[] num1=new int[]{};
//          int[] num2=new int[]{1};
//          System.out.println(solution.findMedianSortedArrays(num1,num2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length+nums2.length];
        if(nums1.length==0){
            arr=nums2;
        }else if(nums2.length==0){
            arr=nums1;
        }else {
            int a=0,b=0;
            for (int i = 0; i < arr.length; i++) {
//            System.out.println("a:"+a+" b:"+b);
                if(a<nums1.length&&nums1[a]<nums2[b]){
                    arr[i]=nums1[a];
                    if(a<nums1.length-1){
                        a++;
                    }else{
//                        tail one of nums1 need to be max so that the rest of nums2 could be added to arr's tail
                        nums1[a]=Integer.MAX_VALUE;
                    }
                }else if(b<nums2.length&&nums2[b]<=nums1[a]){
                    arr[i]=nums2[b];
                    if(b<nums2.length-1){
                        b++;
                    }else{
                        nums2[b]=Integer.MAX_VALUE;
                    }
                }
//                System.out.print(arr[i]+" ");
            }
        }
//        for (int i = 0; i < nums1.length; i++) {
//            arr[i]=nums1[i];
//        }
//        for (int i = nums1.length; i < arr.length; i++) {
//            arr[i]=nums2[i-nums1.length];
//        }
//        Arrays.sort(arr);
//        for (int num : arr) {
//            System.out.print(num+" ");
//        }
        double median=0;
        if(arr.length%2==0){
            median=(arr[arr.length/2-1]+arr[arr.length/2])/2.0;
        }else {
            median=arr[arr.length/2];
        }
        return median;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }