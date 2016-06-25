// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//
// For example,
// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3
public class MovingAverage {

    /** Initialize your data structure here. */
    int size;
    Queue<Integer> queue;
    int sum;
    public MovingAverage(int size) {
      this.size = size;
      this.sum = 0;
      queue = new LinkedList<Integer>();
    }

    public double next(int val) {
      if (queue.size() < size) {
        queue.add(val);
        sum += val;
      }
      else {
        sum -= queue.remove();
        queue.add(val);
        sum += val;
      }
      return sum*1.0/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
