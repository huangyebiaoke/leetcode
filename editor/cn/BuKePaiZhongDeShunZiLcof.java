//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 👍 238 👎 0


import java.util.Arrays;

public class BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
//        System.out.println(solution.isStraight(new int[]{1,2,3,4,5}));
//        System.out.println(solution.isStraight(new int[]{0,0,1,2,5}));
//        System.out.println(solution.isStraight(new int[]{13,1,11,11,4}));
        System.out.println(solution.isStraight(new int[]{11,0,9,0,0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            int[] bucket=new int[14];
            for (int val : nums) {
                bucket[val]++;
                if (val!=0&&bucket[val]==2)
                    return false;
            }

            int i=1,j=13;
            while (bucket[i]==0)
                i++;
            while (bucket[j]==0)
                j--;
//            填充中间的空缺;
            for (int k = i; k <= j; k++) {
                if (bucket[k]==0)
                    bucket[0]--;
            }
//            填充两边的空缺;
            if (j-i+1<5){
                while (j<=13&&bucket[0]>0) {
                    j++;
                    bucket[0]--;
                }
                while (i>=1&&bucket[0]>0) {
                    i--;
                    bucket[0]--;
                }
            }
            return j-i+1==5;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}