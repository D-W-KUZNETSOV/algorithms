
import java.util.Arrays;

public class CustomList implements StringList {

  private String[] elements;
  private int size;


  public CustomList() {
    int DEFAULT_STORAGE_SIZE = 10;
    elements=new String[DEFAULT_STORAGE_SIZE];
    size=0;
  }


  public CustomList(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("Размер массива должен быть больше нуля.");
    }
    this.elements = new String[initialCapacity];
    this.size = 0;
  }



  @Override
  public String add(String item) {
    if (item == null) {
      throw new IllegalArgumentException("Элемент не может быть null.");
    }
    ensureCapacity();
    elements[size++] = item;
    return item;
  }

  @Override
  public String add(int index, String item) {
    if (item == null) {
      throw new IllegalArgumentException("Элемент не может быть null.");
    }
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Индекс выходит за пределы.");
    }
    ensureCapacity();
    System.arraycopy(elements, index, elements, index + 1, size - index);
    elements[index] = item;
    size++;
    return item;
  }

  @Override
  public String set(int index, String item) {
    if (item == null) {
      throw new IllegalArgumentException("Элемент не может быть null.");
    }
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Индекс выходит за пределы.");
    }
    String oldValue = elements[index];
    elements[index] = item;
    return oldValue;
  }

  @Override
  public String remove(String item) {
    int index = indexOf(item);
    if (index == -1) {
      throw new IllegalArgumentException("Элемент не найден.");
    }
    return remove(index);
  }

  @Override
  public String remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Индекс выходит за пределы.");
    }
    String removedElement = elements[index];
    int numMoved = size - index - 1;
    if (numMoved > 0) {
      System.arraycopy(elements, index + 1, elements, index, numMoved);
    }
    elements[--size] = null; // Удаление ссылки для сборщика мусора
    return removedElement;
  }

  @Override
  public boolean contains(String item) {
    return indexOf(item) >= 0;
  }

  @Override
  public int indexOf(String item) {
    for (int i = 0; i < size; i++) {
      if (item.equals(elements[i])) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(String item) {
    for (int i = size - 1; i >= 0; i--) {
      if (item.equals(elements[i])) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public String get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Индекс выходит за пределы.");
    }
    return elements[index];
  }

  @Override
  public boolean equals(StringList otherList) {
    if (otherList == null || this.size != otherList.size()) {
      return false;
    }
    for (int i = 0; i < size; i++) {
      if (!elements[i].equals(otherList.get(i))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void clear() {
    for (int i = 0; i < size; i++) {
      elements[i] = null;
    }
    size = 0;
  }

  @Override
  public String[] toArray() {
    return Arrays.copyOf(elements, size);
  }

  private void ensureCapacity() {
    if (size >= elements.length) {
      elements = Arrays.copyOf(elements, elements.length * 2);
    }
  }
  @Override
  public String toString() {
    return "CustomList{" +
        "elements=" + Arrays.toString(elements) +
        ", size=" + size +
        '}';
  }
}

