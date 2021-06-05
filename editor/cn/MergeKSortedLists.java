//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1320 👎 0

//package leetcode.editor.cn;
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode l1=new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode l2=new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode l3=new ListNode(2,new ListNode(6));
        ListNode listNode=solution.mergeKLists(new ListNode[]{null});
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
        ListNode merge(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = merge(l1.next, l2);
                return l1;
            } else {
                l2.next = merge(l1, l2.next);
                return l2;
            }
        }
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists==null||lists.length==0){
                return null;
            }
//            也可以用归并排序的分治法思想两两合并数组，这样时间复杂度降到O(nlogn)
            ListNode listNode=lists[0];
            for (int i = 1; i < lists.length; i++) {
                listNode=merge(listNode,lists[i]);
            }
            return listNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}