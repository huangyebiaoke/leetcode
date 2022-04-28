//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 👍 346 👎 0


import java.util.List;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        System.out.println(solution.getKthFromEnd(listNode,2).val);

        System.out.println(solution.getKthFromEnd(listNode.next.next.next,1).val);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for singly-linked list.
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head==null||k==0)
                return null;

            ListNode first=head;
            ListNode last=head;
//            为了鲁棒性还要判断k>ListNode.length的情况;
            while (k!=1){
                last=last.next;
                k--;
            }
            while (last.next!=null){
                first=first.next;
                last=last.next;
            }
            return first;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}