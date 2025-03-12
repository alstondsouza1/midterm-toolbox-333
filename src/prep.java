import java.security.PKCS12Attribute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Remove Element from an Array 
 */

// function removeElementInPlace(array, index) 
// if array is null Or Index is out of bounds
// throw error
// copy eleemnts from (index + 1) to (array.length - 1) into (index to array.length)
// set last element to null

public static void removeElementInPlace(String[] array, int index) {
    if (array == null || index < 0 || index >= array.length) {
        throw new IllegalAccessException("Array cannot be null and index must be within bounds");
    }

    System.arraycopy(array, index + 1, array, index, array.length - index - 1);
    array[array.length - 1] = null;
}

/**
 * Add Element in Place
 */

// function addElementInPlace(array, index, value)
// if array i null OR index is out of bounds
// throw error
// copy elements from (index to array.length - 2) into (index + 1 to array.length - 1)
// set array[index] = value

public static void addElementInPlace(String[] array, int index, String value) {
    if (array == null || index < 0 || index >= array.length) {
        throw new IllegalAccessException("Array cannot be null and index must be within bounds");
    }

    System.arraycopy(array, index, array, index + 1, array.length - index - 1);
    array[index] = value;
}

/**
 * Find Tail of a singly linked List (Recursive Approach)
 */

// function findHead(tail)
// if head is null 
// throw error
// if head.prev is null
// return tail
// else return findTail(head.next) 

public static SingleNode findTail(SingleNode head) {
    if (head == null) {
        throw new IllegalAccessException("Head cannot be null");
    }
    return (head.next == null) ? head : findTail(head.next);
}

/**
 * Find head of a Doubly linked List (Recursive Approach)
 */

// function findTail(head)
// if tail is null
// throw error
// if tail.prev is null
// return head
// else return findHead(tail.prev)

public static DoubleNode findHead(DoubleNode tail) {
    if (tail == null) {
        throw new IllegalAccessException("Tail cannot be null");
    }
    return (tail.prev == null) ? tail : findHead(tail.prev);
}

/**
 * Count Occurences in a Linked List (Using HashSet for Unique Elements)
 */

// function countOccurences(head)
// if head is null
// throw error
// create empty map countMap
// create empty set UniqueElements
// set current = head
// while current is not null
// increment countMap[current.data] (default 0 + 1)
// add current.data to uniqueElements
// move current to next node
// print unique elements
// return countMap

public static Map<Integer, Integer> countOccurences(SingleNode head) {
    if (head == null) {
        throw new IllegalAccessException("Head cannot be null");
    }
    Map<Integer, Integer> countMap = new HashMap<>();
    Set<Integer> uniqueElements = new HashSet<>();
    SingleNode current = head;
    
    while (current != null) {
        countMap.put(current.data, countMap.getOrDefault(current.data, 0) + 1);
        uniqueElements.add(current.data);
        current = current.next;
    }

    System.out.println(uniqueElements);
    return countMap;
}

/**
 * Remove Node from a doubly linked list
 */

// function removeNode(node);
// if node is null
// throw error
// if node.prev is not null
// set node.prev.next = node.next
// if node.next is not null
// set node.next.prev = node.prev


public static void removeNode(DoubleNode node) {
    if (node == null) {
        throw new IllegalAccessException("Node cannot be null");
    }

    if (node.prev != null) node.prev.next = node.next;
    if (node.next != null) node.next.prev = node.prev;
}

/**
 * Find Nth Element in a singly linked list (Recursive Approach)
 */

// function findNthElement(head, n)
// if head is null OR n < 0
// throw error
// if n = 0
// return head
// else return findNthElement(head.next, n - 1)

public static SingleNode findNthElement(SingleNode head, int n) {
    if (head == null || n < 0) {
        throw new IllegalAccessException("Head cannot be null and n cannot be negative");
    }

    return (n == 0) ? head : findNthElement(head.next, n - 1);
}

/**
 * 
 */