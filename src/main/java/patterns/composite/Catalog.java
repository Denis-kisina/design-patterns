package patterns.composite;

abstract class Catalog {

  public void add(Catalog catalog) {
    throw new UnsupportedOperationException("Can not return name");
  }

  public void remove(Catalog catalog) {
    throw new UnsupportedOperationException("Can not return name");
  }

  public String getName() {
    throw new UnsupportedOperationException("Can not return name");
  }

  public void printCatalog() {
    throw new UnsupportedOperationException("Can not return name");
  }
}
