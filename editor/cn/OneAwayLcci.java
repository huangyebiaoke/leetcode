//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 👍 146 👎 0


public class OneAwayLcci {
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
//        System.out.println(solution.oneEditAway("pale","ple"));
//        System.out.println(solution.oneEditAway("intention","execution"));
//        System.out.println(solution.oneEditAway("cb","cba"));
        System.out.println(solution.oneEditAway("ab","bc"));
//        System.out.println(solution.oneEditAway("pales","pal"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean isDel(String a,String b){
            int left=0,right=a.length()-1;
            while (left<a.length()-1&&a.charAt(left)==b.charAt(left))
                left++;
            while (right>0&&a.charAt(right)==b.charAt(right-1))
                right--;
            return left==right;
        }

        boolean isRep(String a,String b){
            int left=0,right=a.length()-1;
            while (left<=a.length()-1&&a.charAt(left)==b.charAt(left))
                left++;
            while (right>=0&&a.charAt(right)==b.charAt(right))
                right--;
            return left==right;
        }



        public boolean oneEditAway(String first, String second) {
            if (first.equals(second))
                return true;
            else if (Math.abs(first.length()-second.length())>1)
                return false;
            if (first.length()-second.length()==0)
                return isRep(first,second);
            else if (first.length()-second.length()==1)
                return isDel(first,second);
            else
                return isDel(second,first);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}