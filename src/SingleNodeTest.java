import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Collections;

/**
 * this class tests the funcationalility of the singleNode class,
 */

public class SingleNodeTest {

  /**
   * test creating a single node with data=99 and converting it to a list
   * expecting a list containing exactly [99]
   */

  @Test
  public void testToListWithSingleElement() {
    SingleNode node = new SingleNode(99);
    List<Integer> result = node.toList();
    assertEquals(List.of(99), result);
  }

  /**
   * test linking mulitple nodes:  67 -> 42 -> 15 -> 89 -> 23
   * then converting to a list confirming we get the expected sequence
   */

  @Test
  public void testToListWithMultipleElements() {
    // creating the final node first
    SingleNode node5 = new SingleNode(23);
    // linkk the next references in reverse
    SingleNode node4 = new SingleNode(89, node5);
    SingleNode node3 = new SingleNode(15, node4);
    SingleNode node2 = new SingleNode(42, node3);
    SingleNode node1 = new SingleNode(67, node2);

    List<Integer> result = node1.toList();
    assertEquals(List.of(67, 42, 15, 89, 23), result);
  }

  /**
   * test a node that doe'nt link to any others
   * converting to a list should givbe us just single element: -8
   */

  @Test
  public void testToListWithEmptyNode() {
    SingleNode node = new SingleNode(-8, null); // Node exists but has no next
    List<Integer> result = node.toList();
    assertEquals(List.of(-8), result);
  }

  /**
   * test creating a singly linked list from an empty java list
   * this should throw an expection because we can't build
   * a linked list with zero elements
   */

  @Test
  public void testFromListWithEmptyList() {
    assertThrows(IllegalArgumentException.class,
    () -> SingleNode.fromList(Collections.emptyList()));

  }

  /**
   * test building a list from a single-element list [112]
   * check that the head is not null, its data is 112, and next is null
   */

  @Test
  public void testFromListWithSingleElement() {
    SingleNode head = SingleNode.fromList(List.of(112));
    assertNotNull(head);
    assertEquals(112, head.data);
    assertNull(head.next);
  }

  /**
   * test buildingh a linked list from [50, 3, 99, 17]
   * confirm that each node is linked in the correct order
   * and that the final node points to null
   */

  @Test
  public void testFromListWithMultipleElements() {
    SingleNode head = SingleNode.fromList(List.of(50, 3, 99, 17));

    // check the first node
    assertNotNull(head);
    assertEquals(50, head.data);

    // check the second node
    assertNotNull(head.next);
    assertEquals(3, head.next.data);

    // third node
    assertNotNull(head.next.next);
    assertEquals(99, head.next.next.data);

    // fourth node
    assertNotNull(head.next.next.next);
    assertEquals(17, head.next.next.next.data);

    // end of the list should be null
    assertNull(head.next.next.next.next);
  }

  /**
   * take a regular list, converty it to a single node list
   * 
   */
  @Test
  public void testFromListToListRoundTrip() {
    List<Integer> originalList = List.of(91, 43, 76, 88, 25);
    SingleNode head = SingleNode.fromList(originalList);
    List<Integer> resultList = head.toList();

    assertEquals(originalList, resultList);
  }

  /**
   * test that the code can handle extreme integer values
   * such as MAX_VALUE and MIN_VALUE
   */
  @Test
  public void testToListAndFromListWithEdgeCaseValues() {
    List<Integer> edgeCaseList = List.of(Integer.MAX_VALUE, -200, 0, 450, Integer.MIN_VALUE);
    SingleNode head = SingleNode.fromList(edgeCaseList);
    List<Integer> resultList = head.toList();

    assertEquals(edgeCaseList, resultList);
  }

  /**
   * if pass null instead of a real list, we should get an IllegalArgument Exception
   */

  @Test
  public void testFromListAndNullHandling() {
    assertThrows(IllegalArgumentException.class,
      () -> SingleNode.fromList(null)) ;
  }
}
