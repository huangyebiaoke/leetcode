//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 2004 👎 0


import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        List<List<Integer>> lists=solution.permute(new int[]{0,1});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> lists=new ArrayList<>();
            ArrayList<Integer> list=new ArrayList<>();
            for (int val : nums) {
                list.add(val);
            }
            backtrack(lists,list, 0);
            return lists;
        }
        void swap(ArrayList<Integer> lists,int i,int j){
            int tmp=lists.get(i);
            lists.set(i,lists.get(j));
            lists.set(j,tmp);
        }

        private void backtrack(List<List<Integer>> lists, ArrayList<Integer> list,int idx) {
            if (list.size()-1==idx) {
                lists.add(new ArrayList<>(list));
                return;
            }
            for (int i = idx; i < list.size(); i++) {
                swap(list,i,idx);
                backtrack(lists,list,idx+1);
                swap(list,i,idx);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}