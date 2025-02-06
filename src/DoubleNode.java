import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in a doubly linked list.
 * Each node stores an integer value and has references to the next and previous nodes in the list.
 */
public class DoubleNode {

  /**
   * The data stored in this node.
   */
  public int data;

  /**
   * The reference to the next node in the doubly linked list.
   * If this is the last node in the list, next is null.
   */
  public DoubleNode next;

  /**
   * The reference to the previous node in the doubly linked list.
   * If this is the first node in the list, prev is null.
   */
  public DoubleNode prev;

  /**
   * Constructs a DoubleNode with the specified data and a reference to the next node.
   * The prev reference is initialized to null.
   *
   * @param data the integer value to store in this node
   * @param next the next node in the list, or null if this is the last node
   */
  public DoubleNode(int data, DoubleNode next) {
    this.data = data;
    this.next = next;
    // prev is null by default
  }

  /**
   * Constructs a DoubleNode with the specified data.
   * The next and prev references are initialized to null.
   *
   * @param data the integer value to store in this node
   */
  public DoubleNode(int data) {
    this(data, null);
  }

  /**
   * Converts the doubly linked list starting at this node into a Java List.
   *
   * @return a list containing the values of the nodes in the linked list
   */
  public List<Integer> toList() {
    List<Integer> result = new ArrayList<>();
    DoubleNode current = this;

    // move forward through the list until we run out of nodes
    while (current != null) {
      // take the data from the current node
      result.add(current.data);
      // then move on to the next node
      current = current.next;
    }
    // when current is null, we've reached the end of the list
    return result;
  }

  /**
   * Constructs a doubly linked list from a Java List.
   * The head of the list corresponds to the first element in the input list.
   *
   * @param values a list of integers to convert into a doubly linked list
   * @return the head node of the constructed doubly linked list
   * @throws IllegalArgumentException if the input list is null or empty
   */
  public static DoubleNode fromList(List<Integer> values) {
    // we cna't make a list with no data, so we throw an expecation if it's empty or null
    if (values == null || values.isEmpty()) {
      throw new IllegalArgumentException("Input list cannot be null or empty.");
    }

    // create the head using the first item in the list
    DoubleNode head = new DoubleNode(values.get(0));
    DoubleNode current = head;

    // start at i = 1 because we already used the first value
    for (int i = 1; i < values.size(); i++) {
      // create a new node with the current integer
      DoubleNode newNode = new DoubleNode(values.get(i));
      // link the new node to the chain
      current.next = newNode;
      newNode.prev = current;
      // the update 'current' so we can continue building the chain
      current = newNode;
    }

    return head;
  }
}
