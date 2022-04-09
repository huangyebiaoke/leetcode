//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1517 👎 0


import java.util.Arrays;
import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }

    // Definition for a binary tree node.
    public class TreeNode {
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
        TreeNode buildTree(int[] preorder, int[] inorder,int startPre,int endPre,int startIn, int endIn){
            TreeNode root = new TreeNode(preorder[startPre]);
            if (endPre-startPre == 0 && endIn-startIn == 0)
                return root;
//            根据根节点的值（前序遍历中的第一个位置）获取在中序遍历中的位置；
            int rootInorderIndex = keys.get(root.val);
            int leftTreeLen=rootInorderIndex-startIn;
            if (leftTreeLen > 0) {
                root.left = buildTree(preorder,inorder,startPre+1,startPre+leftTreeLen,startIn,rootInorderIndex-1);
            }
            if (leftTreeLen < endPre-startPre) {
                root.right = buildTree(preorder,inorder,startPre+leftTreeLen+1,endPre,rootInorderIndex+1,endIn);
            }
            return root;
        }
        HashMap<Integer,Integer> keys;
        TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 && inorder.length == 0)
                return null;
//            preorder 和 inorder 均 无重复 元素；
            keys=new HashMap<>();
            for (int i = 0; i < preorder.length; i++) {
                keys.put(inorder[i],i);
            }
            return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}