  //给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2439 👎 0

  import java.util.Arrays;
  import java.util.Collections;

  //package leetcode.editor.cn;
  public class ContainerWithMostWater{
      public static void main(String[] args) {
           Solution solution = new ContainerWithMostWater().new Solution();
          System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
//        当有重复“高度”时失效，这时要用哈希表，反而更麻烦了。
//        int maxValue=0;
//        for (int i = 0; i < height.length; i++) {
//            if (height[i]>maxValue){
//                maxValue=height[i];
//            }
//        }
//        int[] bucket=new int[maxValue+1];
//        for (int i = 0; i < height.length; i++) {
//            bucket[height[i]]=i;
//        }
//        int maxArea=0;
//        for (int i = 0; i < bucket.length-1; i++) {
//            if (bucket[i]!=0){
//                int area=i*Math.abs(bucket[i]-bucket[i+1]);
//                if (area>maxArea){
//                    maxArea=area;
//                }
//            }
//        }
//        return maxArea;
        int i=0,j=height.length-1;
        int maxArea=0;
        while (i!=j) {
            int area=0;
            if (height[i]<height[j]){
                area=(j-i)*height[i];
                i++;
            }else {
                area=(j-i)*height[j];
                j--;
            }
            if (area>maxArea){
                maxArea=area;
            }
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }