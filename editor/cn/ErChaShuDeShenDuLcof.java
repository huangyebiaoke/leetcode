//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-
//tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 187 👎 0


public class ErChaShuDeShenDuLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeShenDuLcof().new Solution();
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        System.out.println(solution.maxDepth(root));
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
        int fd=0;
        void postOrder(TreeNode node,int d){
            if (node==null) {
                fd=Math.max(fd,d);
                return;
            }
            postOrder(node.right,d+1);
            postOrder(node.left,d+1);
        }

        public int maxDepth(TreeNode root) {
            postOrder(root,0);
            return fd;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}