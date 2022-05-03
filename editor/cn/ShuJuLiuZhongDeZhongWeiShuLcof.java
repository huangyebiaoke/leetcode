//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-
//stream/ 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 310 👎 0


import java.util.Comparator;
import java.util.PriorityQueue;

public class ShuJuLiuZhongDeZhongWeiShuLcof {
    public static void main(String[] args) {
        MedianFinder finder = new ShuJuLiuZhongDeZhongWeiShuLcof().new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        finder.addNum(3);
        finder.addNum(4);
        finder.addNum(5);
        finder.addNum(6);
        System.out.println(finder.findMedian());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        PriorityQueue<Integer> minQueue;
        PriorityQueue<Integer> maxQueue;
        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
//            大顶堆
            maxQueue=new PriorityQueue<>((x, y) -> -x.compareTo(y));
//            小顶堆
            minQueue=new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxQueue.size()==minQueue.size()) {
                if (maxQueue.peek()!=null&&num<maxQueue.peek()) {
                    maxQueue.add(num);
                    num=maxQueue.poll();
                }
                minQueue.add(num);
            }else {
                if (minQueue.peek()!=null&&num>minQueue.peek()) {
                    minQueue.add(num);
                    num=minQueue.poll();
                }
                maxQueue.add(num);
            }
        }

        public double findMedian() {
//            System.out.println(maxQueue);
//            System.out.println(minQueue);
            if (maxQueue.size()==minQueue.size()) {
                return (maxQueue.peek()+minQueue.peek())/2.0;
            }
            else return minQueue.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}