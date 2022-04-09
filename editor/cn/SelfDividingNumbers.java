//自除数 是指可以被它包含的每一位数整除的数。 
//
// 
// 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。 
// 
//
// 自除数 不允许包含 0 。 
//
// 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 1, right = 22
//输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
// 
//
// 示例 2: 
//
// 
//输入：left = 47, right = 85
//输出：[48,55,66,77]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= left <= right <= 10⁴ 
// 
// Related Topics 数学 👍 208 👎 0


import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        Solution solution = new SelfDividingNumbers().new Solution();
        System.out.println(solution.selfDividingNumbers(1, 22));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int pow(int x, int y) {
            int res = 1;
            for (int i = 0; i < y; i++) {
                res *= x;
            }
            return res;
        }

        boolean verify(int x) {
            int len = String.valueOf(x).length();
            for (int i = 0; i < len; i++) {
                int num = (x % pow(10, i + 1)) / pow(10, i);
                if (num == 0 || x % num != 0) {
                    return false;
                }
            }
            return true;
        }

        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> list = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                if (verify(i))
                    list.add(i);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}