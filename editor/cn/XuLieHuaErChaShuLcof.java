//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
//binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 297 👎 0


import java.util.Arrays;
import java.util.LinkedList;

public class XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        Codec solution = new XuLieHuaErChaShuLcof().new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        System.out.println(solution.serialize(root));

    }

    //  Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "# ";
            return root.val+ " " + serialize(root.left) + serialize(root.right);
        }

        private TreeNode deserialize(LinkedList<String> data){
            if ("#".equals(data.get(0))){
                data.remove(0);
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(data.get(0)));
            data.remove(0);
            node.left = deserialize(data);
            node.right = deserialize(data);
            return node;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
//            有负数，所以要用String数组而不是char数组
            String[] strings=data.split(" ");
            return deserialize(new LinkedList<String>(Arrays.asList(strings)));
        }
    }
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}