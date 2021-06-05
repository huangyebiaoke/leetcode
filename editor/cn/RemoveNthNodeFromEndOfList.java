//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1378 👎 0

import javax.sound.midi.SoundbankResource;

//package leetcode.editor.cn;
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode l2 = new ListNode(1, new ListNode(2));
        ListNode l3 = new ListNode(1);
        ListNode listNode = solution.removeNthFromEnd(l3, 1);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//     Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode head2=new ListNode();
            head2.next=head;
            ListNode pre=head2,tail=head2;
//            ListNode pre = new ListNode(), tail = new ListNode();
//            pre.next = head;
//            tail.next = head;
            int dis = 0;
            while (tail != null) {
                tail = tail.next;
                dis++;
//                System.out.println("tail:"+tail.val+" "+dis);
                if (dis > n+1) {
                    pre = pre.next;
                    dis--;
//                    System.out.println("pre:"+pre.val+" "+dis);
                }
            }
            pre.next = pre.next.next;
            return head2.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}