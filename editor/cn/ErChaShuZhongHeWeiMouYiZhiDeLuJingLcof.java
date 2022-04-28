//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 328 👎 0


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        List<List<Integer>> result = solution.pathSum(root, 22);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
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

        List<List<Integer>> res = new ArrayList<>();

        void preOrder(TreeNode node, int currentSum, int target, LinkedList<Integer> path) {
            if (node == null)
                return;
            currentSum += node.val;
            path.addLast(node.val);
            if (node.left == null && node.right == null && currentSum == target) {
//                值赋值，引用复制
                res.add(new LinkedList<>(path));
            }
            if (node.left != null) {
                preOrder(node.left, currentSum, target, path);
            }
            if (node.right != null) {
                preOrder(node.right, currentSum, target, path);
            }
//            回溯
            path.removeLast();
        }

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            LinkedList<Integer> path=new LinkedList<>();
            preOrder(root, 0, target, path);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}