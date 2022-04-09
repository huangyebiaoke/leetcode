//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i 
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 10⁴ 
// arr.length 是偶数 
// -10⁵ <= arr[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 哈希表 排序 👍 85 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        Solution solution = new ArrayOfDoubledPairs().new Solution();
        int[] arr1=new int[]{4,4,8,8,8,8,2,2,16,16,1,32};
        System.out.println(solution.canReorderDoubled(arr1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean verify(int[] arr){
            for (int i = 0; i < arr.length/2; i++) {
                if (arr[2*i+1]!=2*arr[2*i])
                    return false;
            }
            return true;
        }

        void swap(int[] arr, int i, int j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }

        boolean isD=false;
        void per(int[] arr,int index){
            if (isD||index==arr.length){
                if (verify(arr))
                    isD=true;
                return;
            }
            for (int i = index; i < arr.length; i++) {
                swap(arr,i,index);
                per(arr,index+1);
                swap(arr,i,index);
            }
        }

        public boolean canReorderDoubled(int[] arr) {
            per(arr,0);
            return isD;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}