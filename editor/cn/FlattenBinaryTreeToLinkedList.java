//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1168 👎 0


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode root= new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        solution.flatten(root);
        while (root!=null){
            System.out.println(root.val);
            root=root.right;
        }
//        TreeNode root2=new TreeNode(0);
//        solution.flatten(root2);
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
        void preOrder(TreeNode node, List<TreeNode> list){
            if (node==null)
                return;
            list.add(node);
            preOrder(node.left,list);
            preOrder(node.right,list);
        }
        void copy(TreeNode node, List<TreeNode> list){
            if (list.isEmpty())
                return;
            node.right=list.get(0);
            node.left=null;
            list.remove(0);
            copy(node.right,list);
        }

        public void flatten(TreeNode root) {
            if (root==null)
                return;
            List<TreeNode> list=new LinkedList<>();
            preOrder(root,list);
            root=list.get(0);
            list.remove(0);
            copy(root,list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}