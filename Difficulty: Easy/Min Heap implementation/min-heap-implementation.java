class minHeap {
    ArrayList<Integer> heap;

    minHeap() {
        heap = new ArrayList<>();
    }

    // Insert an element
    void push(int x) {
        heap.add(x);

        int i = heap.size() - 1;

        // Heapify Up
        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(parent) > heap.get(i)) {
                int temp = heap.get(parent);
                heap.set(parent, heap.get(i));
                heap.set(i, temp);

                i = parent;
            } else {
                break;
            }
        }
    }

    // Remove minimum element
    void pop() {
        if (heap.size() == 0)
            return;

        int last = heap.size() - 1;

        // Swap root with last
        int temp = heap.get(0);
        heap.set(0, heap.get(last));
        heap.set(last, temp);

        // Remove last
        heap.remove(last);

        int i = 0;

        // Heapify Down
        while (true) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < heap.size() && heap.get(left) < heap.get(smallest))
                smallest = left;

            if (right < heap.size() && heap.get(right) < heap.get(smallest))
                smallest = right;

            if (smallest == i)
                break;

            temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);

            i = smallest;
        }
    }

    // Return minimum element
    int peek() {
        if (heap.size() == 0)
            return -1;

        return heap.get(0);
    }

    // Return size
    int size() {
        return heap.size();
    }
}