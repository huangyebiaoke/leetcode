//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 111 👎 0


public class SuccessorLcci {
    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
//        TreeNode root=new TreeNode(2);
//        root.left=new TreeNode(1);
//        root.right=new TreeNode(3);
//        System.out.println(solution.inorderSuccessor(root,new TreeNode(1)).val);
        TreeNode root2=new TreeNode(5);
        root2.right=new TreeNode(6);
        root2.left=new TreeNode(3);
        root2.left.right=new TreeNode(4);
        root2.left.left=new TreeNode(2);
        root2.left.left.left=new TreeNode(1);
        System.out.println(solution.inorderSuccessor(root2,new TreeNode(6)).val);


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
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode ans = null;
            while (root!=null){
                if (p.val<root.val){
//                    由于BST的性质,root的前继节点只能出现在左子树;
                    ans=root;
                    root=root.left;
                }else {
                    root=root.right;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}