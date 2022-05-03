//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 426 👎 0


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{0,0,0,2,0,5},3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] getLeastNumbers(int[] arr, int k) {
            if(arr.length==0||k==0)
                return new int[0];
            PriorityQueue<Integer> queue=new PriorityQueue<>(k, (o1, o2) -> -o1.compareTo(o2));
            for (int val : arr) {
                queue.add(val);
                if (queue.size()>k)
                    queue.poll();
            }
            int[] res=new int[k];
            for (int i = 0; i < res.length; i++)
                res[i]=queue.poll();
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}