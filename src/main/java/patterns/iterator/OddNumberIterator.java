package patterns.iterator;

import java.util.Iterator;
import java.util.List;

class OddNumberIterator<T> implements Iterator<T> {

  private final List<T> list;
  private int position;

  public OddNumberIterator(List<T> list) {
    this.list = list;
    this.position = 0;
  }

  @Override
  public boolean hasNext() {
    while(position < list.size()) {
      if(position % 2 != 0)
        return true;
      else
        position++;
    }
    return false;
  }

  @Override
  public T next() {
    return list.get(position++);
  }
}
