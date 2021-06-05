//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1289 👎 0

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode ln = new ListNode(1);
        ListNode temp = ln;
        for (int i=2;i<100;i++){
            temp.next=new ListNode(i);
            temp=temp.next;
        }
        ln=solution.reverseList(ln);
        temp=ln;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head==null){
                return null;
            }
            if(head.next==null) {
                return head;
            }
            ListNode last=reverseList(head.next);
            head.next.next=head;
            head.next=null;
            return last;
//            ListNode dummy=head;
//            ListNode next=null;
//            while (head.next!=null) {
//                next=head.next;
//                head.next=next.next;
//                next.next=dummy;
//                dummy=next;
//            }
//            return dummy;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}