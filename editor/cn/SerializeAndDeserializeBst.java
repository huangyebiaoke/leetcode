//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 304 👎 0


import java.util.Arrays;
import java.util.LinkedList;

public class SerializeAndDeserializeBst {
    public static void main(String[] args) {
        Codec codec = new SerializeAndDeserializeBst().new Codec();
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(1);
        root.right=new TreeNode(3);
        System.out.println(codec.serialize(root));
        TreeNode root2=codec.deserialize(codec.serialize(root));
        System.out.println(root2.val+" "+root2.left.val+" "+root2.right.val);
    }

//    Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class Codec {

        TreeNode node;
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root==null)
                return "#,";
            return root.val+","+serialize(root.left)+serialize(root.right);
        }

        private TreeNode deserialize(LinkedList<String> list){
            if (list.get(0).equals("#")){
                list.remove(0);
                return null;
            }
            TreeNode node=new TreeNode(Integer.parseInt(list.get(0)));
            list.remove(0);
            node.left=deserialize(list);
            node.right=deserialize(list);
            return node;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strings=data.split(",");
            return deserialize(new LinkedList<>(Arrays.asList(strings)));
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}