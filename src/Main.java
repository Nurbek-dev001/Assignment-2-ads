public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing MyArrayList ===");
        testMyArrayList();

        System.out.println("\n=== Testing MyLinkedList ===");
        testMyLinkedList();

        System.out.println("\n=== Testing MyStack ===");
        testMyStack();

        System.out.println("\n=== Testing MyQueue ===");
        testMyQueue();

        System.out.println("\n=== Testing MyMinHeap ===");
        testMyMinHeap();
    }

    private static void testMyArrayList() {
        MyList<Integer> arrList = new MyArrayList<>();

        arrList.add(10);
        arrList.add(20);
        arrList.addFirst(5);
        arrList.addLast(30);
        arrList.add(2, 15);  // Insert at index 2

        System.out.println("ArrayList after additions: " + arrayToString(arrList.toArray()));
        System.out.println("Size: " + arrList.size());  // Expected: 5

        // Test get methods
        System.out.println("First element: " + arrList.getFirst());  // 5
        System.out.println("Last element: " + arrList.getLast());    // 30
        System.out.println("Element at index 2: " + arrList.get(2)); // 15

        // Test exists and indexOf
        System.out.println("Contains 20? " + arrList.exists(20));  // true
        System.out.println("Index of 15: " + arrList.indexOf(15));  // 2
        System.out.println("Last index of 10: " + arrList.lastIndexOf(10)); // 1

        // Test removal
        arrList.remove(1);  // Remove 10
        System.out.println("After removing index 1: " + arrayToString(arrList.toArray()));

        arrList.removeFirst();
        System.out.println("After removeFirst: " + arrayToString(arrList.toArray()));

        arrList.removeLast();
        System.out.println("After removeLast: " + arrayToString(arrList.toArray()));

        // Test set
        arrList.set(0, 100);
        System.out.println("After set index 0 to 100: " + arrayToString(arrList.toArray()));

        // Test sort
        arrList.add(50);
        arrList.add(25);
        arrList.sort();
        System.out.println("After sorting: " + arrayToString(arrList.toArray()));

        // Test clear
        arrList.clear();
        System.out.println("After clear, size: " + arrList.size());  // 0
    }

    private static void testMyLinkedList() {
        MyList<String> linkedList = new MyLinkedList<>();

        linkedList.add("Audi");
        linkedList.add("BMW");
        linkedList.addFirst("ford");
        linkedList.addLast("Lexus");
        linkedList.add(2, "Omoda");

        System.out.println("LinkedList after additions: " + arrayToString(linkedList.toArray()));
        System.out.println("Size: " + linkedList.size());  // Expected: 5

        // Test get methods
        System.out.println("First element: " + linkedList.getFirst());  // "ford"
        System.out.println("Last element: " + linkedList.getLast());    // "leha"
        System.out.println("Element at index 2: " + linkedList.get(2)); // "omada"

        // Test exists and indexOf
        System.out.println("'BMW' bar ma? " + linkedList.exists("BMW"));  // true
        System.out.println("Index of 'orange': " + linkedList.indexOf("Omoda"));  // 2

        // Test iterator
        System.out.println("Iterating through list:");
        for (String item : linkedList) {
            System.out.println("\t" + item);
        }

        // Test removal
        linkedList.remove(1);  // Remove "apple"
        System.out.println("After removing index 1: " + arrayToString(linkedList.toArray()));

        linkedList.removeFirst();
        System.out.println("After removeFirst: " + arrayToString(linkedList.toArray()));

        linkedList.removeLast();
        System.out.println("After removeLast: " + arrayToString(linkedList.toArray()));

        // Test set
        linkedList.set(0, "Chery");
        System.out.println("After set index 0 to 'Chery':" + arrayToString(linkedList.toArray()));

        // Test sort
        linkedList.add("Audi");
        linkedList.add("chevrolet");
        linkedList.sort();
        System.out.println("After sorting: " + arrayToString(linkedList.toArray()));
    }

    private static void testMyStack() {
        MyStack<Integer> stack = new MyStack<>();

        System.out.println("New stack is empty? " + stack.isEmpty());  // true

        // Test push and peek
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("After pushes, peek: " + stack.peek());  // 30
        System.out.println("Stack size: " + stack.size());         // 3

        // Test pop
        System.out.println("First pop: " + stack.pop());  // 30
        System.out.println("Second pop: " + stack.pop()); // 20
        System.out.println("After pops, size: " + stack.size()); // 1

        // Test peek
        System.out.println("Current peek: " + stack.peek());  // 10

        // Test empty stack
        stack.pop();
        System.out.println("After all pops, is empty? " + stack.isEmpty());  // true
    }

    private static void testMyQueue() {
        MyQueue<String> queue = new MyQueue<>();

        System.out.println("New queue is empty? " + queue.isEmpty());  // true

        // Test enqueue
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        System.out.println("After enqueues, peek: " + queue.peek());  // "first"
        System.out.println("Queue size: " + queue.size());           // 3

        // Test dequeue
        System.out.println("First dequeue: " + queue.dequeue());  // "first"
        System.out.println("Second dequeue: " + queue.dequeue()); // "second"
        System.out.println("After dequeues, size: " + queue.size()); // 1

        // Test peek
        System.out.println("Current peek: " + queue.peek());  // "third"

        // Test empty queue
        queue.dequeue();
        System.out.println("After all dequeues, is empty? " + queue.isEmpty());  // true
    }

    private static void testMyMinHeap() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        System.out.println("New heap is empty? " + heap.isEmpty());  // true

        // Test insert and getMin
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(4);

        System.out.println("Current min: " + heap.getMin());  // 1
        System.out.println("Heap size: " + heap.size());     // 5

        // Test extractMin
        System.out.println("Extracted min: " + heap.extractMin());  // 1
        System.out.println("New min: " + heap.getMin());           // 3
        System.out.println("After extraction, size: " + heap.size()); // 4

        // Test multiple extractions
        System.out.println("Extracting all elements:");
        while (!heap.isEmpty()) {
            System.out.print(heap.extractMin() + " ");  // Should print in order: 3, 4, 5, 8
        }
        System.out.println("\nAfter all extractions, is empty? " + heap.isEmpty());  // true
    }

    private static String arrayToString(Object[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}