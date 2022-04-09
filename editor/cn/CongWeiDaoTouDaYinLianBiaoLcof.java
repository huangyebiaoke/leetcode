//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 268 👎 0


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(Arrays.toString(solution.reversePrint(listNode)));
    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        ListNode(int x, ListNode node) {
            val = x;
            next = node;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] reversePrint(ListNode head) {
            int size = 0;
            ListNode cur = head;
            while (cur != null) {
                cur = cur.next;
                size++;
            }
            int[] res = new int[size];
            for (int i = res.length - 1; i >= 0; i--) {
                res[i] = head.val;
                head = head.next;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}