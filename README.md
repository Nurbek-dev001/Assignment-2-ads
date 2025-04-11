## Description for My assignment-2:ArrayList and LinkedList

## Author: Nurbek Bolarbek

## Group: BDA-2409
# Data Structures Implementation in Java

This project provides custom implementations of fundamental data structures in Java without relying on `java.util.*` collections (except for `Iterator`). The implementations include both physical and logical data structures.

## Implemented Data Structures

### Physical Data Structures (Implementing `MyList<T>` interface)
1. **MyArrayList** - A resizable array implementation
2. **MyLinkedList** - A doubly-linked list implementation

### Logical Data Structures
1. **MyStack** (using MyArrayList as underlying structure)
2. **MyQueue** (using MyLinkedList as underlying structure)
3. **MyMinHeap** (using MyArrayList as underlying structure)

## Features

### MyList Interface
The base interface that provides common operations for list implementations:
- Add/remove elements at any position
- Get/set elements by index
- First/last element operations
- Searching and sorting
- Conversion to array
- Iterable implementation

### MyArrayList
- Dynamic resizing when capacity is reached
- O(1) access by index
- O(n) insertion/removal in middle

### MyLinkedList
- Doubly-linked node structure
- O(1) insertion/removal at head/tail
- O(n) access by index
- Prevents circular references

### MyStack (LIFO)
- Push/pop/peek operations
- O(1) time complexity for all operations
- Uses MyArrayList for efficient end operations

### MyQueue (FIFO)
- Enqueue/dequeue/peek operations
- O(1) time complexity for all operations
- Uses MyLinkedList for efficient head/tail operations

### MyMinHeap
- Insert/extract-min operations
- O(log n) time complexity for key operations
- Maintains heap property
- Requires comparable elements

## Complexity Analysis

| Operation         | MyArrayList | MyLinkedList | MyStack | MyQueue | MyMinHeap |
|-------------------|-------------|--------------|---------|---------|-----------|
| Access by index   | O(1)        | O(n)         | -       | -       | -         |
| Insert at end     | O(1)*       | O(1)         | O(1)    | O(1)    | -         |
| Insert at start   | O(n)        | O(1)         | -       | -       | -         |
| Insert middle     | O(n)        | O(n)         | -       | -       | -         |
| Remove from end   | O(1)        | O(1)         | O(1)    | -       | -         |
| Remove from start | O(n)        | O(1)         | -       | O(1)    | -         |
| Remove middle     | O(n)        | O(n)         | -       | -       | -         |
| Search            | O(n)        | O(n)         | -       | -       | -         |
| Sort              | O(n²)       | O(n²)        | -       | -       | -         |
| Heap Insert       | -           | -            | -       | -       | O(log n)  |
| Heap ExtractMin   | -           | -            | -       | -       | O(log n)  |
| Heap PeekMin      | -           | -            | -       | -       | O(1)      |

*O(1) amortized due to occasional resizing

## Design Choices

1. **Stack Implementation**: Uses MyArrayList because stacks only need efficient operations at one end, and arrays provide better memory locality.

2. **Queue Implementation**: Uses MyLinkedList because queues need efficient operations at both ends, which linked lists provide.

3. **Heap Implementation**: Uses MyArrayList because heaps need efficient random access to parent/child nodes, which arrays provide with index arithmetic.

4. **Sorting**: Implemented simple bubble sort for demonstration. In production, more efficient algorithms would be preferred.

## Testing

The project includes comprehensive test cases in the Main class that verify:
- Basic operations for all data structures
- Edge cases (empty collections, boundary conditions)
- Iterator functionality
- Sorting correctness
- Heap property maintenance

