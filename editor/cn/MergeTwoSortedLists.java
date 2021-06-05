//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1722 👎 0

//package leetcode.editor.cn;
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode listNode = solution.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        ListNode l3 = new ListNode(), cur = l3;
        void merge(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                cur.next = l1 == null ? l2 : l1;
                return;
            }
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
//            System.out.println(l1.val);
                merge(l1.next, l2);
            } else {
                cur.next = l2;
                cur = cur.next;
//            System.out.println(l2.val);
                merge(l1, l2.next);
            }
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            merge(l1, l2);
            return l3.next;
//        if (l1==null){
//            return l2;
//        }else if (l2==null){
//            return l1;
//        }
//        if (l1.val<l2.val){
//            l1.next=mergeTwoLists(l1.next,l2);
//            return l1;
//        }else {
//            l2.next=mergeTwoLists(l1,l2.next);
//            return l2;
//        }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}