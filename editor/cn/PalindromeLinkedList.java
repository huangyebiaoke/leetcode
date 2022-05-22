//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1391 👎 0


import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(0);
        listNode.next.next=new ListNode(1);
        System.out.println(solution.isPalindrome(listNode));
    }

    //    Definition for singly-linked list.
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

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        ListNode preNode;
        boolean check(ListNode curNode){
            if (curNode!=null){
                if (!check(curNode.next))
                    return false;
                if (curNode.val!= preNode.val)
                    return false;
                preNode=preNode.next;
            }
            return true;
        }
        public boolean isPalindrome(ListNode head) {
            preNode=head;
            return check(head);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}