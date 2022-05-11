//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 👍 228 👎 0


import java.util.Arrays;

public class GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
        System.out.println(Arrays.toString(solution.constructArr(new int[]{1,2,3,4,5})));
//        System.out.println(Arrays.toString(solution.constructArr(new int[]{3,2})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            if (a==null||a.length==0)
                return new int[0];
            int[] ans=new int[a.length];
//            自上而下计算左下三角形每一行的乘积;
            ans[0]=1;
            for (int i = 1; i < a.length; i++) {
                ans[i]=ans[i-1]*a[i-1];
            }
//            自下而上计算右上三角形每一行的乘积, 计入tmp;
            int tmp=1;
            for (int i = a.length-2; i >= 0; i--) {
                tmp*=a[i+1];
                ans[i]*=tmp;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}