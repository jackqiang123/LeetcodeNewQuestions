// Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
// Examples:
//
// [2,3,4] , the median is 3
//
// [2,3], the median is (2 + 3) / 2 = 2.5
//
// Design a data structure that supports the following two operations:
//
//     void addNum(int num) - Add a integer number from the data stream to the data structure.
//     double findMedian() - Return the median of all elements so far.
//
// For example:
//
// add(1)
// add(2)
// findMedian() -> 1.5
// add(3)
// findMedian() -> 2

public class MedianFinder {
    PriorityQueue<Integer> leftPart = new PriorityQueue<>(10, Collections.reverseOrder());
    PriorityQueue<Integer> rightPart = new PriorityQueue<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
      if (leftPart.size() == 0) leftPart.add(num);
      else if (leftPart.size() == rightPart.size()) {
        if (rightPart.peek() < num) {
          rightPart.add(num);
          num = rightPart.remove();
        }
        leftPart.add(num);
      }
      else {
        if (leftPart.peek() >= num){
          leftPart.add(num);
          rightPart.add(leftPart.remove());
        }
        else rightPart.add(num);
      }
    }

    // Returns the median of current data stream
    public double findMedian() {
      if (leftPart.size() == rightPart.size()){
        return (leftPart.peek() + rightPart.peek())/2.0;
      }
      else return leftPart.peek();
    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
