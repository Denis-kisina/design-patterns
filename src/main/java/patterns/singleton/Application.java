package patterns.singleton;

class Application {

  public static void main(String[] args) {
    CustomerDAO customerDAO = new CustomerDAO();
    customerDAO.save();

    ProductDAO productDAO = new ProductDAO();
    productDAO.save();
  }
}
