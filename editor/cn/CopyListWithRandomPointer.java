//给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。 
//
// 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 
//指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。 
//
// 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random 
//--> y 。 
//
// 返回复制链表的头节点。 
//
// 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示： 
//
// 
// val：一个表示 Node.val 的整数。 
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。 
// 
//
// 你的代码 只 接受原链表的头节点 head 作为传入参数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 1000 
// -10⁴ <= Node.val <= 10⁴ 
// Node.random 为 null 或指向链表中的节点。 
// 
// Related Topics 哈希表 链表 👍 871 👎 0


public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
        Node node=new Node(7);
        node.next=new Node(13);
        node.next.next=new Node(11);
        node.next.next.next=new Node(10);
        node.next.next.next.next=new Node(1);
        node.next.random=node;
        node.next.next.random=node.next.next.next.next;
        node.next.next.next.random=node.next.next;
        node.next.next.next.next.random=node;
        Node res=solution.copyRandomList(node);
        for (; res!=null ; res=res.next) {
                System.out.print(res.val+" ");
                if (res.random!=null)
                    System.out.print(res.random.val+" ");
                else
                    System.out.print("null ");
        }
    }

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        void copyLink(Node head){
            while (head!=null) {
                Node node = new Node(head.val);
                node.next = head.next;
                head.next = node;
                head = head.next.next;
            }
        }
        void copyRandom(Node head){
            Node pre=head;
            Node nxt=head.next;
            while (nxt!=null){
                if (pre.random!=null) {
                    nxt.random = pre.random.next;
//                    System.out.println(nxt.random.val);
                }
                if (nxt.next==null)
                    break;
                pre=pre.next.next;
                nxt=nxt.next.next;
            }
        }

        Node divideLink(Node head){
            Node pre=head;
            Node nxt=head.next,divide=head.next;
            while (nxt.next!=null){
//                System.out.println(pre.val);
                pre.next=pre.next.next;
                nxt.next=nxt.next.next;
                pre=pre.next;
                nxt=nxt.next;
            }
            pre.next=pre.next.next;
            return divide;
        }

        public Node copyRandomList(Node head) {
            if (head==null)
                return null;
            copyLink(head);
            copyRandom(head);
            return divideLink(head);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}