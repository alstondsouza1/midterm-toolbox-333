import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Collections;

/**
 * this class contains tests for the DoubleNode class
 */

public class DoubleNodeTest {

  /**
   * in this tests, we create a single node with data=77
   * since there's only one node, it's 'next' and 'prev' should be null
   * convery it to a list and expect exactly one element (77)
   */

  @Test
  public void testToListWithSingleElement() {
    DoubleNode node = new DoubleNode(77);
    List<Integer> result = node.toList();
    assertEquals(List.of(77), result);
  }

  /**
   * here, we manually chain 5 nodes together (81 -> 22 -> 9 -> 36 -> 14)
   * confirm that converting into a java list
   * gives the same sequence of values in order
   */

  @Test
  public void testToListWithMultipleElements() {
    // setting up the last node first
    DoubleNode node5 = new DoubleNode(14);
    // linking each node to the next
    DoubleNode node4 = new DoubleNode(36, node5);
    DoubleNode node3 = new DoubleNode(9, node4);
    DoubleNode node2 = new DoubleNode(22, node3);
    DoubleNode node1 = new DoubleNode(81, node2);

    // wiring the 'prev' links so it's truly a doubly linked list
    node2.prev = node1;
    node3.prev = node2;
    node4.prev = node3;
    node5.prev = node4;

    List<Integer> result = node1.toList();
    assertEquals(List.of(81, 22, 9, 36, 14), result);
  }

  /**
   * when we try to create a doubly linked list from an empty list,
   * the code should throw an IllegalArgumentException
   */

  @Test
  public void testFromListWithEmptyList() {
    assertThrows(IllegalArgumentException.class,
        () -> DoubleNode.fromList(Collections.emptyList()));
  }

  /**
   * if the input list has exactly one value (64), we geta single-node list
   * check that node is not null and its data is 64
   * and both 'next' and 'prev' are null
   */

  @Test
  public void testFromListWithSingleElement() {
    DoubleNode head = DoubleNode.fromList(List.of(64));
    assertNotNull(head);
    assertEquals(64, head.data);
    assertNull(head.next);
    assertNull(head.prev);
  }

  /**
   * in this test, the input list has four values (3, 7, 20, 55)
   * create a doubly linked list and verify the structure
   * - head = 3
   * - head.next = 7, head.next.prev = head
   * - head.next.next = 20 and so on
   * 
   * we keep confirming that 'prev' links are correctly pointing backward, 
   * and that the end of the list has a null 'next'
   */

  @Test
  public void testFromListWithMultipleElements() {
    DoubleNode head = DoubleNode.fromList(List.of(3, 7, 20, 55));

    // Verify the doubly linked list structure
    assertNotNull(head);
    assertEquals(3, head.data);
    assertNotNull(head.next);
    assertEquals(7, head.next.data);
    assertEquals(head, head.next.prev);
    assertNotNull(head.next.next);
    assertEquals(20, head.next.next.data);
    assertEquals(head.next, head.next.next.prev);
    assertNotNull(head.next.next.next);
    assertEquals(55, head.next.next.next.data);
    assertEquals(head.next.next, head.next.next.next.prev);
    assertNull(head.next.next.next.next);
  }

  /**
   * start with a regular java list and convert it into a doubly linked list,
   * then convert it back to a java list. the result should match the original list, 
   * verifying a perfect 'round-trip'
   */

  @Test
  public void testFromListToListRoundTrip() {
    List<Integer> originalList = List.of(12, 45, 78, 34, 19);
    DoubleNode head = DoubleNode.fromList(originalList);
    List<Integer> resultList = head.toList();

    assertEquals(originalList, resultList);
  }

  /**
   * this test uses some special integer values
   */

  @Test
  public void testToListAndFromListWithEdgeCaseValues() {
    List<Integer> edgeCaseList = List.of(Integer.MIN_VALUE, 101, -87, 0, Integer.MAX_VALUE);
    DoubleNode head = DoubleNode.fromList(edgeCaseList);
    List<Integer> resultList = head.toList();

    assertEquals(edgeCaseList, resultList);
  }

  // lastly, we verify that trying to call fromList(null) also throws an exception

  @Test
  public void testFromListAndNullHandling() {
    assertThrows(IllegalArgumentException.class,
      () -> DoubleNode.fromList(null));
  }
}
