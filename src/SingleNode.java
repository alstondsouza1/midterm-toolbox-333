import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in a singly linked list.
 * Each node contains an integer value and a reference to the next node in the list.
 */
public class SingleNode {

  /**
   * The integer value stored in this node.
   */
  public int data;

  /**
   * A reference to the next node in the singly linked list.
   * This is null if there is no next node.
   */
  public SingleNode next;

  /**
   * Constructs a SingleNode with the specified data and a reference to the next node.
   *
   * @param data the integer value to store in this node
   * @param next the next node in the list, or null if there is no next node
   */
  public SingleNode(int data, SingleNode next) {
    this.data = data;
    this.next = next;
  }

  /**
   * Constructs a SingleNode with the specified data.
   * The next reference is initialized to null.
   *
   * @param data the integer value to store in this node
   */
  public SingleNode(int data) {
    this(data, null);
  }

  /**
   * Converts the singly linked list starting at this node into a Java List.
   *
   * @return a list containing the values of the nodes in the linked list
   */
  public List<Integer> toList() {
    List<Integer> result = new ArrayList<>();
    // start at this ccurent node and keep moving forward
    SingleNode current = this;
    // going until we have no more nodes
    while (current != null) {
      // add the current node's data to our list
      result.add(current.data);
      // move on to the next node
      current = current.next;
    }
    return result;
  }

  /**
   * Constructs a singly linked list from a Java List.
   * The head of the list corresponds to the first element in the input list.
   *
   * @param values a list of integers to convert into a singly linked list
   * @return the head node of the constructed singly linked list, or null if the input list is empty
   * @throws IllegalArgumentException if the input list is null or empty
   */
  public static SingleNode fromList(List<Integer> values) {
    // can't bult a linked list if the list is null or empty
    // so we throw an exception to know something went wrong
    if (values == null || values.isEmpty()) {
      throw new IllegalArgumentException("Input list cannot be null or empty.");
    }

    // make the first node using the first element in 'values'
    SingleNode head = new SingleNode(values.get(0));
    // keep on track of the "current" node, starting with 'head'
    SingleNode current = head;

    // for the remaining integers, we create new nodes and link them up
    for (int i = 1; i < values.size(); i++) {
      // build a new node
      current.next = new SingleNode(values.get(i));
      // advance the pointer
      current = current.next;
    }

    return head;
  }
}
