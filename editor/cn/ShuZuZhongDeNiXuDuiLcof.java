//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 698 👎 0


import java.util.Arrays;

public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] aux;

        private void sort(int[] a) {
            aux = new int[a.length];
            sum=0;
            sort(a, 0, a.length - 1);
        }

        private void sort(int[] a, int lo, int hi) {
            if (lo >= hi)
                return;
            int mid = (lo + hi) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

        private int sum;
        private void merge(int[] a, int lo, int mid, int hi) {
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }
            for (int k = lo; k <= hi; k++) {
                if (i > mid)
                    a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (aux[j] < aux[i]) {
                    a[k] = aux[j++];
                    sum+=(mid-i+1);
                }
                else a[k] = aux[i++];
            }
        }

        public int reversePairs(int[] nums) {
            sort(nums);
//            System.out.println(Arrays.toString(nums));
            return sum;
//            Time Limit Exceeded
//            int sum = 0;
//            for (int step = 1; step < nums.length; step++) {
//                for (int i = 0; i < nums.length - step; i++) {
//                    if (nums[i] > nums[i + step])
//                        sum++;
//                }
//            }
//            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}