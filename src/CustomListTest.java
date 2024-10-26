
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
  private StringList stringList;

  @BeforeEach
  public void setUp() {
    stringList = new CustomList(5);
  }

  @Test
  public void testAddAndSize() {
    assertEquals(0, stringList.size());
    stringList.add("Hello");
    assertEquals(1, stringList.size());
    stringList.add("World");
    assertEquals(2, stringList.size());
  }

  @Test
  public void testAddAtIndex() {
    stringList.add("Hello");
    stringList.add(0, "World");
    assertEquals("World", stringList.get(0));
    assertEquals("Hello", stringList.get(1));
  }

  @Test
  public void testSet() {
    stringList.add("Hello");
    stringList.set(0, "World");
    assertEquals("World", stringList.get(0));
  }

  @Test
  public void testRemoveByValue() {
    stringList.add("Hello");
    stringList.add("World");
    stringList.remove("Hello");
    assertEquals(1, stringList.size());
    assertEquals("World", stringList.get(0));
  }

  @Test
  public void testRemoveByIndex() {
    stringList.add("Hello");
    stringList.add("World");
    stringList.remove(0);
    assertEquals(1, stringList.size());
    assertEquals("World", stringList.get(0));
  }

  @Test
  public void testContains() {
    stringList.add("Hello");
    assertTrue(stringList.contains("Hello"));
    assertFalse(stringList.contains("World"));
  }

  @Test
  public void testIndexOf() {
    stringList.add("Hello");
    stringList.add("World");
    assertEquals(0, stringList.indexOf("Hello"));
    assertEquals(-1, stringList.indexOf("NotFound"));
  }

  @Test
  public void testLastIndexOf() {
    stringList.add("Hello");
    stringList.add("World");
    stringList.add("Hello");
    assertEquals(2, stringList.lastIndexOf("Hello"));
    assertEquals(-1, stringList.lastIndexOf("NotFound"));
  }

  @Test
  public void testGet() {
    stringList.add("Hello");
    assertEquals("Hello", stringList.get(0));
  }

  @Test
  public void testClear() {
    stringList.add("Hello");
    stringList.clear();
    assertTrue(stringList.isEmpty());
  }

  @Test
  public void testToArray() {
    stringList.add("Hello");
    stringList.add("World");
    String[] expected = {"Hello", "World"};
    assertArrayEquals(expected, stringList.toArray());
  }

  @Test
  public void testEquals() {
    StringList anotherList = new CustomList(5);
    stringList.add("Hello");
    anotherList.add("Hello");
    assertTrue(stringList.equals(anotherList));
  }

  @Test
  public void testExceptionOnNullAdd() {
    assertThrows(IllegalArgumentException.class, () -> stringList.add(null));
  }

  @Test
  public void testExceptionOnAddAtInvalidIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> stringList.add(1, "Hello"));
  }

  @Test
  public void testExceptionOnSetInvalidIndex() {
    stringList.add("Hello");
    assertThrows(IndexOutOfBoundsException.class, () -> stringList.set(1, "World"));
  }

  @Test
  public void testExceptionOnRemoveNotFound() {
    stringList.add("Hello");
    assertThrows(IllegalArgumentException.class, () -> stringList.remove("World"));
  }

  @Test
  public void testExceptionOnGetInvalidIndex() {
    stringList.add("Hello");
    assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(1));
  }


}
