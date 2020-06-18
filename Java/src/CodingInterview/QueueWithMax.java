package CodingInterview;

import java.util.ArrayDeque;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/17
 *     标题   :
 *     题目   :
 *     思路   :
 * </pre>
 */
class QueueWithMax {

    ArrayDeque<Integer> dataQueue;
    ArrayDeque<Integer> maxQueue;

    public QueueWithMax() {
        dataQueue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if (dataQueue.size() == 0) {
            return -1;
        }
        return maxQueue.getFirst();
    }

    public void push_back(int value) {
        dataQueue.add(value);
        while (!maxQueue.isEmpty() && maxQueue.getLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if (dataQueue.size() == 0) {
            return -1;
        }
        int value = dataQueue.pop();
        if (value == maxQueue.getFirst()) {
            maxQueue.pop();
        }
        return value;
    }
}
