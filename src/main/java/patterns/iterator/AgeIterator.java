package patterns.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class AgeIterator<T extends Comparable<T>> implements Iterator<T> {

  private final List<T> list;
  private int position;

  public AgeIterator(List<T> list) {
    Collections.sort(list);
    this.list = list;
    this.position = 0;
  }

  public Iterator<T> iterator() {
    return this;
  }

  @Override
  public boolean hasNext() {
    return position < list.size();
  }

  @Override
  public T next() {
    return list.get(position++);
  }
}
