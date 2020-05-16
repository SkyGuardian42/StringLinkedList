package malte;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author malte
 */
public class StringLinkedListTest {
  /**
   * Test of add method, of class StringLinkedList.
   */
  @Test
  public void testAdd_String() {
    System.out.println("add");
    StringLinkedList instance = new StringLinkedList();
    instance.add("Demo Text One");
    instance.add("Demo Text Two");
  }

  /**
   * Test of add method, of class StringLinkedList.
   */
  @Test
  public void testAdd_int_String() {
    System.out.println("add");
    StringLinkedList instance = new StringLinkedList();
    instance.add(0, "Hello ");
    instance.add(1, "are you?");
    instance.add(1, "how ");
    instance.add(0, "Yo! ");
  }

  /**
   * Test of contains method, of class StringLinkedList.
   */
  @Test
  public void testContains() {
    System.out.println("contains");
    String value = "";
    StringLinkedList instance = new StringLinkedList();
    
    instance.add("Hello");
    instance.add("There");
    instance.add("General");
    
    boolean result = instance.contains("Hello");
    assertEquals(true, result);
   
    result = instance.contains("General");
    assertEquals(true, result);
    
    result = instance.contains("Kenobi");
    assertEquals(false, result);
  }

  /**
   * Test of indexOf method, of class StringLinkedList.
   */
  @Test
  public void testIndexOf() {
    System.out.println("indexOf");
    StringLinkedList instance = new StringLinkedList();
    instance.add("Hello");
    instance.add("There");

    int result = instance.indexOf("Hello");
    assertEquals(0, result);

    result = instance.indexOf("There");
    assertEquals(1, result);
    
    result = instance.indexOf("World");
    assertEquals(-1, result);
  }

  /**
   * Test of remove method, of class StringLinkedList.
   */
  @Test
  public void testRemove_String() {
    System.out.println("remove");
    StringLinkedList instance = new StringLinkedList();
    instance.add("One");
    instance.add("Two");
    
    boolean result = instance.remove("One");
    assertEquals(true, result);
    
    result = instance.remove("Three");
    assertEquals(false, result);
  }

  /**
   * Test of remove method, of class StringLinkedList.
   */
  @Test
  public void testRemove_int() {
    System.out.println("remove");
    StringLinkedList instance = new StringLinkedList();
    instance.add("One");
    instance.add("Two");
    instance.add("Three");

    String result = instance.remove(0);
    assertEquals("One", result);
    
    result = instance.remove(1);
    assertEquals("Three", result);
  }

  /**
   * Test of get method, of class StringLinkedList.
   */
  @Test
  public void testGet() {
    System.out.println("get");
    int index = 0;
    StringLinkedList instance = new StringLinkedList();
    instance.add("One");
    instance.add("Two");
    instance.add("Three");

    String result = instance.get(0);
    assertEquals("One", result);

    result = instance.get(2);
    assertEquals("Three", result);
  }

  /**
   * Test of size method, of class StringLinkedList.
   */
  @Test
  public void testSize() {
    System.out.println("size");
    StringLinkedList instance = new StringLinkedList();

    int result = instance.size();
    assertEquals(0, result);
    
    instance.add("Demo");
    result = instance.size();
    assertEquals(1, result);
  }

  
}
