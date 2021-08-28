package patterns.composite;

import java.util.ArrayList;
import java.util.List;

class ProductCatalog extends Catalog {

  private final String categoryName;
  private final List<Catalog> catalogs;

  public ProductCatalog(String categoryName) {
    this.categoryName = categoryName;
    this.catalogs = new ArrayList<>();
  }

  @Override
  public String getName() {
    return this.categoryName;
  }

  @Override
  public void printCatalog() {
    catalogs.forEach(Catalog::printCatalog);
  }

  @Override
  public void add(Catalog catalog) {
    catalogs.add(catalog);
  }

  @Override
  public void remove(Catalog catalog) {
    catalogs.remove(catalog);
  }
}
