//几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？ 
//
// 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。 
//
// 例 1： 
//
// 
//输入: m = 3, n = 3, k = 5
//输出: 3
//解释: 
//乘法表:
//1	2	3
//2	4	6
//3	6	9
//
//第5小的数字是 3 (1, 2, 2, 3, 3).
// 
//
// 例 2： 
//
// 
//输入: m = 2, n = 3, k = 6
//输出: 6
//解释: 
//乘法表:
//1	2	3
//2	4	6
//
//第6小的数字是 6 (1, 2, 2, 3, 4, 6).
// 
//
// 注意： 
//
// 
// m 和 n 的范围在 [1, 30000] 之间。 
// k 的范围在 [1, m * n] 之间。 
// 
// Related Topics 二分查找 👍 213 👎 0


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInMultiplicationTable {
    public static void main(String[] args) {
        Solution solution = new KthSmallestNumberInMultiplicationTable().new Solution();
//        System.out.println(solution.findKthNumber(3,3,6));
        System.out.println(solution.findKthNumber(2,4,100787757));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int m, int n, int k) {
            int[] arr=new int[m+n-1];
            if (m==n) {
                for (int i = 0; i < arr.length / 2; i++) {
                    arr[i] = i + 1;
                }
                for (int i = arr.length / 2; i < arr.length; i++) {
                    arr[i] = arr.length-i;
                }
            }else{
                int less=Math.min(m,n);
                int more=Math.max(m,n);
                for (int i = 0; i < less; i++) {
                    arr[i]=i+1;
                }
                for (int i = less; i < more; i++) {
                    arr[i]=less;
                }
                for (int i = more; i < arr.length; i++) {
                    arr[i] = arr.length-i;
                }
            }
            int tmp=0;
            int i = 0;
            for (; i < arr.length; i++) {
                tmp+=arr[i];
                if (tmp>=k) {
                    tmp-=arr[i];
                    break;
                }
            }


            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}