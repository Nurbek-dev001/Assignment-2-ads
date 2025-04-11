public class MyMinHeap<T extends Comparable<T>> {
    private final MyList<T> list;

    public MyMinHeap() {
        // ArrayList is better for heap implementation.because we need random access to elements
        this.list = new MyArrayList<>();
    }

    public void insert(T item) {
        list.add(item);
        heapifyUp(list.size() - 1);
    }

    public T extractMin() {
        if (isEmpty()) return null;
        T min = list.get(0);
        T last = list.get(list.size() - 1);
        list.set(0, last);
        list.removeLast();
        heapifyDown(0);
        return min;
    }

    public T getMin() {
        if (isEmpty()) return null;
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parentIndex)) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        int leftChild, rightChild, minChild;
        while (true) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            minChild = index;

            if (leftChild < list.size() && list.get(leftChild).compareTo(list.get(minChild)) < 0) {
                minChild = leftChild;
            }

            if (rightChild < list.size() && list.get(rightChild).compareTo(list.get(minChild)) < 0) {
                minChild = rightChild;
            }

            if (minChild == index) {
                break;
            }

            swap(index, minChild);
            index = minChild;
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}