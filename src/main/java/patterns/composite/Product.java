package patterns.composite;

class Product extends Catalog {

  private final String name;
  private final double price;

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public void printCatalog() {
    System.out.println("Product name: " + getName() + " Price: " + getPrice());
  }
}
