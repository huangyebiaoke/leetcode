//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1575 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
//        TreeNode root=new TreeNode(2);
//        root.left=new TreeNode(1);
//        root.right=new TreeNode(3);
//        System.out.println(solution.isValidBST(root));
//        TreeNode root2=new TreeNode(5);
//        root2.left=new TreeNode(1);
//        root2.right=new TreeNode(4);
//        root2.right.left=new TreeNode(3);
//        root2.right.right=new TreeNode(6);
//        System.out.println(solution.isValidBST(root2));
//        TreeNode root3=new TreeNode(1);
//        root3.left=new TreeNode(1);
//        System.out.println(solution.isValidBST(root3));
        TreeNode root4=new TreeNode(5);
        root4.left=new TreeNode(4);
        root4.right=new TreeNode(6);
        root4.right.left=new TreeNode(3);
        root4.right.right=new TreeNode(7);
        System.out.println(solution.isValidBST(root4));
    }

    //    Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        long pre=Long.MIN_VALUE;
        public boolean isValidBST(TreeNode root) {
            if (root==null)
                return true;
            if (!isValidBST(root.left))
                return false;
//            pre记录中序遍历的结果, BST的中序遍历结果严格升序;
            if (root.val<=pre)
                return false;
            pre=root.val;
            return isValidBST(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}