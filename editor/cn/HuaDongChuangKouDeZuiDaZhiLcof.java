//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 434 👎 0


import java.util.*;

public class HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
//        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{},0)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1},1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums==null||nums.length==0)
                return new int[0];
            PriorityQueue<Integer> queue=new PriorityQueue<>((o1, o2) -> -Integer.compare(o1,o2));
            int[] ans=new int[nums.length-k+1];
            int idx=0;
            for (int i = 0; i < nums.length; i++) {
                queue.offer(nums[i]);
                if (queue.size()>k)
                    queue.remove(nums[i-k]);
                if (queue.size()==k)
                    ans[idx++]=queue.peek();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}