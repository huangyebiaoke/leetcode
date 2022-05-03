//给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 👍 116 👎 0


import java.util.LinkedList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new AllElementsInTwoBinarySearchTrees().new Solution();
        TreeNode root1=new TreeNode(2);
        root1.left=new TreeNode(1);
        root1.right=new TreeNode(4);
        TreeNode root2=new TreeNode(1);
        root2.left=new TreeNode(0);
        root2.right=new TreeNode(3);
        System.out.println(solution.getAllElements(root1,root2));
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
        void inOrder(TreeNode node, List<Integer> list){
            if (node==null)
                return;
            inOrder(node.left,list);
            list.add(node.val);
            inOrder(node.right,list);
        }

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            LinkedList<Integer> list1=new LinkedList<>();
            LinkedList<Integer> list2=new LinkedList<>();
            inOrder(root1,list1);
            inOrder(root2,list2);
            return merge(list1,list2);
        }

        private List<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
            List<Integer> result=new LinkedList<>();
            while (!list1.isEmpty()&&!list2.isEmpty()){
                if (list1.peekFirst()<list2.peekFirst())
                    result.add(list1.pollFirst());
                else result.add(list2.pollFirst());
            }
            if (!list1.isEmpty())
                result.addAll(list1);
            if (!list2.isEmpty())
                result.addAll(list2);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}