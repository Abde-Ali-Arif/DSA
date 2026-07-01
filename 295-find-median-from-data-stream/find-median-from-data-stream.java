class MedianFinder {

    PriorityQueue<Integer> left;   // Max Heap
    PriorityQueue<Integer> right;  // Min Heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        left.offer(num);

        right.offer(left.poll());

        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        // if total elements is even
        return (left.peek() + right.peek()) / 2.0;
    }
}