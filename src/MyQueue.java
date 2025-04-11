public class MyQueue<T> {
    private final MyList<T> list;

    public MyQueue() {
        // LinkedList
        this.list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        if (isEmpty()) return null;
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}