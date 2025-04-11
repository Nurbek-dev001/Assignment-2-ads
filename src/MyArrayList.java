import java.util.Iterator;
import java.util.NoSuchElementException;
public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;
    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    @Override
    public void add(T item) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = item;
    }
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        array[index] = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        if (size == array.length) {
            increaseCapacity();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    @Override
    public T getFirst() {
        if (size == 0) throw new NoSuchElementException("List is empty");
        return get(0);
    }

    @Override
    public T getLast() {
        if (size == 0) throw new NoSuchElementException("List is empty");
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    @Override
    public void removeFirst() {
        if (size == 0) throw new NoSuchElementException("List is empty");
        remove(0);
    }

    @Override
    public void removeLast() {
        if (size == 0) throw new NoSuchElementException("List is empty");
        remove(size - 1);
    }

    @Override
    public void sort() {
        // Using bubble sort for simplicity
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) array[j]).compareTo((T) array[j + 1]) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (T) array[currentIndex++];
            }
        };
    }

    private void increaseCapacity() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}