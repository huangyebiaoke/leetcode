//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 设计 队列 单调队列 👍 361 👎 0


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DuiLieDeZuiDaZhiLcof {
    public static void main(String[] args) {
        MaxQueue maxQueue = new DuiLieDeZuiDaZhiLcof().new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        MaxQueue maxQueue2 = new DuiLieDeZuiDaZhiLcof().new MaxQueue();
        System.out.println(maxQueue2.pop_front());
        System.out.println(maxQueue2.max_value());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    单调队列
    class MaxQueue {
        Queue<Integer> dataQueue;
        Deque<Integer> maxQueue;

        public MaxQueue() {
            dataQueue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public int max_value() {
            return maxQueue.isEmpty()?-1:maxQueue.peekFirst();
        }

        public void push_back(int value) {
            while (!maxQueue.isEmpty() && value > maxQueue.peekLast())
                maxQueue.pollLast();
            maxQueue.offerLast(value);
            dataQueue.offer(value);
        }

        public int pop_front() {
            if (dataQueue.isEmpty())
                return -1;
            int ans=dataQueue.poll();
            if (maxQueue.peekFirst()==ans)
                maxQueue.pollFirst();
            return ans;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}