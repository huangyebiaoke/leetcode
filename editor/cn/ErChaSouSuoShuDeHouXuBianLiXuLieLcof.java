//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 496 👎 0


import java.util.Arrays;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
//        System.out.println(solution.verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
        System.out.println(solution.verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
//            System.out.println(Arrays.toString(postorder));
            if (postorder==null||postorder.length<=2)
                return true;
            int root=postorder[postorder.length-1];
            int index=0;
            while (postorder[index]<root)
                index++;
            int mid=index;
            while (postorder[index]>root)
                index++;
            return index==postorder.length-1&&verifyPostorder(Arrays.copyOfRange(postorder, 0, mid))&&verifyPostorder(Arrays.copyOfRange(postorder, mid, postorder.length-1));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}