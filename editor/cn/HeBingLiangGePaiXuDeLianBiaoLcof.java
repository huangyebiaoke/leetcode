//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 237 👎 0


public class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(5);
        ListNode l2=new ListNode(2);
        l2.next=new ListNode(4);
        l2.next.next=new ListNode(6);
        l2.next.next.next=new ListNode(8);
        l2.next.next.next.next=new ListNode(10);
        ListNode l3=solution.mergeTwoLists(l1,l2);
        while (l3!=null){
            System.out.print(l3.val+" ");
            l3=l3.next;
        }
    }

    //  Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode l3=new ListNode(0);
            ListNode cur=l3;
            while (l1!=null&&l2!=null){
                if (l1.val<l2.val){
                    cur.next=l1;
                    l1=l1.next;
                }else {
                    cur.next=l2;
                    l2=l2.next;
                }
                cur=cur.next;
            }
            if (l1==null)
                cur.next=l2;
            if (l2==null)
                cur.next=l1;
            return l3.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}