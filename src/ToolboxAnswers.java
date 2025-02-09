import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class ToolboxAnswers {

 /**
   * Removes an element from an array of strings at the specified index, padding with nulls at the end.
   *
   * @param array the array of strings to modify
   * @param index the index of the element to remove
   * @throws IllegalArgumentException if the array is null or the index is out of bounds
   */

  /**
   * if array is null or index is out of bounds 
   * then throw error
   * for i from index to array.length -2
   * then array[i] = array[i + 1]
   * array[array.lenght - 1] = null
   */ 
  public static void removeElementInPlace(String[] array, int index) {

    // Checks to see if the array is null or if the index is out of bounds
    if (array == null || index < 0 || index >= array.length) {
      throw new IllegalArgumentException("Array cannot be null and index must be within bounds.");
    }

    // We will shift the elements to the left starting from the index to remove
    for (int i = index; i < array.length - 1; i++) {
      // Move the next element to the current position
      array[i] = array[i + 1];
    }

    // Set the last element to null since we shifted everything left.
    array[array.length - 1] = null;
    
  }

  /**
   * Adds an element to an array of strings at a specified location in-place, evicting the last value.
   *
   * @param array the array of strings to modify
   * @param index the index at which to add the new element
   * @param value the value to add
   * @throws IllegalArgumentException if the array is null or the index is out of bounds
   */
  public static void addElementInPlace(String[] array, int index, String value) {
    // Checks to see if the array is null or if the index is out of bounds
    if (array == null || index < 0 || index >= array.length) {
      throw new IllegalArgumentException("Array cannot be null and index must be within bounds.");
    }

    // Shift elements to the right starting from the last element down to the index
    for (int i = array.length - 1; i > index; i--) {
      // Move the previous element to the right
      array[i] = array[i - 1];
    }

    // Insert the new value at the specified index
    array[index] = value;
  }

  /**
   * Finds the tail of a singly linked list given the head.
   *
   * @param head the head node of the singly linked list
   * @return the tail node of the list, or null if the list is empty
   * @throws IllegalArgumentException if the head is null
   */
  public static SingleNode findTail(SingleNode head) {
    // Check if the head is null, which means the list doesn't exist
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null.");
    }

    // Start with the given head node
    SingleNode current = head;

    // Traverse the list until we reach the last node (tail)
    while (current.next != null) {
      // Move to the next node
      current = current.next;
    }

    // The last node is the tail, return it
    return current; 
  }

  /**
   * Finds the head of a doubly linked list given the tail.
   *
   * @param tail the tail node of the doubly linked list
   * @return the head node of the list, or null if the list is empty
   * @throws IllegalArgumentException if the tail is null
   */
  public static DoubleNode findHead(DoubleNode tail) {
    // Check if the head is null, which means the list doesn't exist
    if (tail == null) {
      throw new IllegalArgumentException("Tail cannot be null.");
    }

    // Start with the given tail node
    DoubleNode current = tail;

    // Traverse the list backwards until we reach the first node (head)
    while (current.prev != null) {
      // Move to the previous node
      current = current.prev;
    }

    // The first node is the head, return it
    return current; 
  }

  /**
   * Counts the occurrences of values in a linked list.
   *
   * @param head the head node of the linked list
   * @return a map where the keys are the values in the list, and the values are the counts of occurrences
   * @throws IllegalArgumentException if the head is null
   */
  public static Map<Integer, Integer> countOccurrences(SingleNode head) {
    // Check if the head is null, which means the list doesn't exist
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null.");
    }
    // Create a map to the count of each number. Keys being numbers in the list and Values of how many times each number appears
    Map<Integer, Integer> countMap = new HashMap<>();

    // Pointer will be set at the first node, which is head
    SingleNode current = head;

    // Loop until the end of the list (null)
    while (current != null) {
      // I fht number exists in the map, increase its count by 1 
      // Otherwise, set it to 1 as the first occurence
      countMap.put(current.data, countMap.getOrDefault(current.data, 0) + 1);
      
      // Move to the next node in the linked list
      current = current.next;
    }

    // Return the final map
    return countMap; 
  }

  /**
   * Removes a node from a doubly linked list.
   *
   * @param node the node to remove
   * @throws IllegalArgumentException if the node is null
   */
  public static void removeNode(DoubleNode node) {
    // Check if the node is null
    if (node == null) {
      throw new IllegalArgumentException("Node cannot be null.");
    }

    // Update the previous node's next reference
    if (node.prev != null) {
      // Skip over the node being removed
      node.prev.next = node.next;
    }

    // Update the next node's previous reference
    if (node.next != null) {
      // Skip back to the previous node
      node.next.prev = node.prev;
    }

    // Disconnect the node from the list
    node.prev = null; // Remove reference to the previous node
    node.next = null; // Remove reference to the next node
  }

  /**
   * Finds the nth element in a singly linked list.
   *
   * @param head the head node of the singly linked list
   * @param n the index of the element to find (0-based)
   * @return the nth node, or null if the index is out of bounds
   * @throws IllegalArgumentException if the head is null or n is negative
   */
  public static SingleNode findNthElement(SingleNode head, int n) {
    // Ensuring the list exists and n is valid
    if (head == null || n < 0) {
      throw new IllegalArgumentException("Head cannot be null and n cannot be negative.");
    }

    // Start from the head, by creating a pointer
    SingleNode current = head;
    int count = 0; // counter to track the position

    // Move through the list until we reach the nth element
    while (current != null && count < n) {
      current = current.next; // Move to the next node
      count++;
    }

    // Return the found node (or null if out of bounds)
    return current; // Will be null if n is too large 
  }

  /**
   * Inserts a new node into a singly linked list given a pointer to a node in the middle of the list.
   *
   * @param node the node before which the new node is to be inserted
   * @param newNode the new node to insert
   * @throws IllegalArgumentException if either node or newNode is null
   */
  public static void insertNode(SingleNode node, SingleNode newNode) {
    // Ensure node and newNode are not null
    if (node == null || newNode == null) {
      throw new IllegalArgumentException("Node and newNode cannot be null.");
    }

    // Link the newNode into the list
    newNode.next = node.next; // newNode points to the next node in the list
    node.next = newNode; // Previous node now points to the newNode

    // newNode is now inserted into the middle of the list
  }

  /**
   * Rotates a queue to the left by the specified number of positions in-place.
   * 
   * The first k elements of the queue are moved to the end, preserving the order
   * of all elements.
   *
   * Example:
   * Given a queue [1, 2, 3, 4, 5] and k = 2, the result will be [3, 4, 5, 1, 2].
   *
   * @param queue the queue to rotate
   * @param k the number of positions to rotate to the left
   * @throws IllegalArgumentException if the queue is null or k is negative
   */
  public static void rotateQueueLeft(Queue<Integer> queue, int k) {
    // Ensure queue is valid and k is non-negative
    if (queue == null || k < 0) {
      throw new IllegalArgumentException("Queue cannot be null and k cannot be negative.");
    }

    // Optimize k to prevent unnecessary full rotations
    k = k % queue.size(); // if k >= queue size, only rotate the remainder

    // Remove the first k elements and add them back to the end
    for (int i = 0; i < k; i++) {
      int front = queue.poll(); // Remove from the front
      queue.offer(front); // Add to the back
    }

    // Queue is now rotated to the left by k positions
    
  }

  /**
   * Checks if a string has balanced parentheses using a stack.
   * 
   * A string is considered to have balanced parentheses if each opening parenthesis
   * '(' has a corresponding closing parenthesis ')', and the parentheses are correctly nested.
   *
   * Example:
   * - Input: "(()())" -> Returns true
   * - Input: "(()" -> Returns false
   * - Input: ")" -> Returns false
   *
   * @param input the string to check
   * @return true if the string has balanced parentheses, false otherwise
   * @throws IllegalArgumentException if the input string is null
   */
  public static boolean hasBalancedParentheses(String input) {
    // Ensure input is not null
    if (input == null) {
      throw new IllegalArgumentException("Input string cannot be null.");
    }

    // Use a stack to keep track of open parentheses
    Stack<Character> stack = new Stack<>();

    // Traverse each character in the string
    for (char c : input.toCharArray()) {
      if (c == '(') {
        stack.push(c); // Push opening '(' onto the stack
      } else if (c == ')') {
        // If we encounter a closing parenthesis, check the stack
        if (stack.isEmpty()) {
          return false; // No matching opening parenthesis
        }
        stack.pop(); // Remove the Last '(' from the stack
      }
    }
    return stack.isEmpty(); // Return true if stack is empty (all pairs matched)
  }
}
