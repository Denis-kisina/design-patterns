package patterns.composite;

class Application {

  public static void main(String[] args) {

    //Create composite product catalog
    Catalog bakeryCatalog = new ProductCatalog("Bakery");
    Catalog groceryCatalog = new ProductCatalog("Grocery");

    //Create products and add
    Catalog bread = new Product("Bread", 1.9);
    Catalog sugar = new Product("Sugar", 2.9);
    Catalog milk = new Product("Milk", 4.9);


    bakeryCatalog.add(bread);
    bakeryCatalog.add(sugar);
    bakeryCatalog.add(milk);


    Catalog beef = new Product("Beef", 10.9);
    Catalog carrot = new Product("Carrot", 1.0);
    groceryCatalog.add(beef);
    groceryCatalog.add(carrot);

    Catalog mainCatalog = new ProductCatalog("Primary Catalog");
    mainCatalog.add(bakeryCatalog);
    mainCatalog.add(groceryCatalog);

    mainCatalog.printCatalog();
  }
}
