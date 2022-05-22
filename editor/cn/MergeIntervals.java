//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1475 👎 0


import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();

        int[][] intervals=new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        };
        int[][] intervals2=new int[][]{
                {1,4},{4,5}
        };
        int[][] intervals3=new int[][]{
                {1,4}
        };
        int[][] intervals4=new int[][]{
                {1,4},{0,4}
        };
        int[][] intervals5=new int[][]{
                {1,4},{2,3}
        };
        int[][] intervals6=new int[][]{
                {1,4},{0,2},{3,5}
        };
        int[][] res=solution.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length==1)
                return intervals;
//            排序
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//            入栈出栈
            Deque<int[]> stack=new LinkedList<>();
            stack.push(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] pre=stack.peek();
                if (intervals[i][0]<=pre[1]) {
                    pre = new int[]{Math.min(pre[0], intervals[i][0]), Math.max(pre[1], intervals[i][1])};
                    stack.pop();
                    stack.push(pre);
                }else {
                    stack.push(intervals[i]);
                }
            }
            return stack.toArray(new int[stack.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}