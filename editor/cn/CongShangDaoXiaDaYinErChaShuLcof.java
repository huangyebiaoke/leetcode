//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 189 👎 0


import java.util.*;

public class CongShangDaoXiaDaYinErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(Arrays.toString(solution.levelOrder(root)));
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
        int count(TreeNode root) {
            if (root == null)
                return 0;
            return count(root.left) + 1 + count(root.right);
        }

        public int[] levelOrder(TreeNode root) {
            if (root==null)
                return new int[0];
            Deque<TreeNode> queue = new LinkedList<>();
            int[] print = new int[count(root)];
            queue.add(root);
            int i = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                print[i++] = node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            return print;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}