package patterns.singleton;

class ConnectionPool {

  private static ConnectionPool pool = new ConnectionPool();

  private Connection connection = new Connection();

  private ConnectionPool() {
  }

  public static ConnectionPool getPool() {
    return pool;
  }

  public Connection getConnection() {
    return connection;
  }
}
