//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 737 👎 0


import java.util.Arrays;

public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
    }

    //     Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length==0&&inorder.length==0)
                return null;
            TreeNode root=new TreeNode(preorder[0]);
            if (preorder.length==1&&inorder.length==1)
                return root;
            int rootInorderIndex=0;
            while (inorder[rootInorderIndex]!=root.val)
                rootInorderIndex++;
            if (rootInorderIndex>0){
//                [from,to)
                root.left=buildTree(Arrays.copyOfRange(preorder,1,rootInorderIndex+1),Arrays.copyOfRange(inorder,0,rootInorderIndex));
            }
            if (rootInorderIndex<preorder.length){
                root.right=buildTree(Arrays.copyOfRange(preorder,rootInorderIndex+1,preorder.length),Arrays.copyOfRange(inorder,rootInorderIndex+1,inorder.length));
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}