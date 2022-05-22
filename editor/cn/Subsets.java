//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1630 👎 0


import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        List<List<Integer>> lists=solution.subsets(new int[]{1,2,3});
//        List<List<Integer>> lists=solution.subsets(new int[]{0});
        for (List<Integer> list: lists){
            System.out.println(list);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        void sub(List<List<Integer>> ans,LinkedList<Integer> cur,int[] nums,int idx){
            for (int i = idx; i < nums.length; i++) {
                cur.add(nums[i]);
                ans.add(new LinkedList<>(cur));
                sub(ans,cur,nums,i+1);
                cur.removeLast();
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> lists=new LinkedList<>();
            sub(lists,new LinkedList<>(),nums,0);
            lists.add(new LinkedList<>());
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}