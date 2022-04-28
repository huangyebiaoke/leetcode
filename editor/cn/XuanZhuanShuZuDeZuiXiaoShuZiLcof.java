//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
//
// 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3
//,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。 
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], 
//..., a[n-2]] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numbers = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：numbers = [2,2,2,0,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == numbers.length 
// 1 <= n <= 5000 
// -5000 <= numbers[i] <= 5000 
// numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转 
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/ 
// Related Topics 数组 二分查找 👍 597 👎 0


public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
//        System.out.println(solution.minArray(new int[]{3,4,5,0,1,1,1,1,2}));
//        System.out.println(solution.minArray(new int[]{2,2,2,0,1}));
//        System.out.println(solution.minArray(new int[]{1,0,1,1,1}));
//        System.out.println(solution.minArray(new int[]{1,1,1,0,1}));
//        System.out.println(solution.minArray(new int[]{1,2,3,4,5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int search(int[] numbers) {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i + 1] < numbers[i]) {
                    return numbers[i + 1];
                }
            }
            return numbers[0];
        }

        public int minArray(int[] numbers) {
            int lo = 0, hi = numbers.length - 1;
            int mid = lo;
            while (numbers[hi] <= numbers[lo]) {
//                System.out.println(lo+" "+mid+" "+hi);
                if (hi - lo == 1)
                    return numbers[hi];
                mid = (lo + hi) >>> 1;
                if (numbers[lo] == numbers[mid] && numbers[mid] == numbers[hi])
                    return search(numbers);
                if (numbers[mid] >= numbers[lo])
                    lo = mid;
                else if (numbers[mid] <= numbers[hi])
                    hi = mid;
            }
            return numbers[mid];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}