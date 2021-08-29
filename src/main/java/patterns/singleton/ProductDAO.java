package patterns.singleton;

class ProductDAO {

  Connection conn;

  public ProductDAO() {
    conn = ConnectionPool.getPool().getConnection();
  }

  public void save(){
    conn.open();
  }
}
