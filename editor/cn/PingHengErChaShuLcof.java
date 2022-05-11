//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 二叉树 👍 275 👎 0


public class PingHengErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new PingHengErChaShuLcof().new Solution();
        TreeNode root= new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        System.out.println(solution.isBalanced(root));
        TreeNode root2=new TreeNode(1);
        root2.left=new TreeNode(2);
        root2.right=new TreeNode(2);
        root2.left.left=new TreeNode(3);
        root2.left.right=new TreeNode(3);
        root2.left.left.left=new TreeNode(4);
        root2.left.left.right=new TreeNode(4);
        System.out.println(solution.isBalanced(root2));
    }

    //    Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        由下至上遍历二叉树
        int postOrder(TreeNode node){
            if (node==null) {
                return 0;
            }
            int left=postOrder(node.left);
            if (left==-1) return -1;
            int right=postOrder(node.right);
            if (right==-1) return -1;
//            当左右子树的高度差<=1时，是平衡二叉树，深度+1；否则直接返回-1；
            return Math.abs(left-right)<=1?Math.max(left,right)+1:-1;
        }
        public boolean isBalanced(TreeNode root) {
            return postOrder(root)!=-1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}