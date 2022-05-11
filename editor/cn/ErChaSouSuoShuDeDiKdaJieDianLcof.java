//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 296 👎 0


public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        TreeNode root= new TreeNode(3);
//        root.left=new TreeNode(1);
//        root.right=new TreeNode(4);
//        root.left.right=new TreeNode(2);
        System.out.println(solution.kthLargest(root,1));
    }

//    Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        int val=0;
        int count=0;
        void inorder(TreeNode node,int k){
            if (node==null)
                return;
            inorder(node.right,k);
            if (++count==k) {
                val = node.val;
                return;
            }
            inorder(node.left,k);
        }
        public int kthLargest(TreeNode root, int k) {
            inorder(root,k);
            return val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}