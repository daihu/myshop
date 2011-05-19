package myshop.db;

import java.sql.*;

/**
 * 数据库连接控制类。通过访问静态方法获得数据库连接
 */
public abstract class ConnectionManager {
  /** 获得连接池连接 */
  public static final int TYPE_POOLED = 0;

  /** 获得直接物理连接 */
  public static final int TYPE_DIRECT = 1;

  /** 私有空构造方法。保证本类不能够被实例化 */
  private ConnectionManager() {
  }

  /**
   * 获得默认连接方式的数据库连接。目前默认为物理连接。
   * @return Connection 数据库连接
   */
  public static Connection getConnection() {
    return getConnection(TYPE_DIRECT);
  }

  /**
   * 获得指定连接方式的数据库连接
   * @param type int 连接方式 <br/>
   * ConnectionManager.TYPE_POOLED 数据库连接池连接 <br/>
   * ConnectionManager.TYPE_DIRECT 直接物理连接
   * @return Connection 数据库连接
   */
  public static Connection getConnection(int type) {
    Connection conn = null;
    switch (type) {
    case TYPE_DIRECT:
      try {
        // 定义JDBC驱动程序
        String driverName = "org.gjt.mm.mysql.Driver"; // MySQL JDBC 驱动程序名称
        Class.forName(driverName);

        // 数据库连接参数。指定采用中文编码方式连接数据库
        String serverName = "localhost"; // 数据库主机名称
        String mydatabase = "my_shop"; // 数据库名称
        // 连接url。指定连接方式为GBK编码
        String url = "jdbc:mysql://" + serverName + "/" +
                     mydatabase +
                     "?useUnicode=true&characterEncoding=GBK";
        String username = "root"; // 连接用户名
        String password = "111111"; // 连接密码

        // 获得数据库连接
        conn = DriverManager.getConnection(url, username, password);
      } catch (ClassNotFoundException e) {
        // 不能够找到所需类
        e.printStackTrace();
      } catch (SQLException e) {
        // 获得数据库连接发生异常
        e.printStackTrace();
      }
      break;
    case TYPE_POOLED:
      throw new UnsupportedOperationException("Now Unsupported.");
    }
    return conn;
  }

  /**
   * 关闭数据库连接
   * @param conn Connection 需要被关闭的数据库连接
   */
  public static void closeConnection(Connection conn) {
    if (conn != null) { //连接是否有效
      try {
        if (!conn.isClosed()) { //连接是否已关闭
          conn.close(); //关闭连接
        }
      } catch (SQLException ex1) {
        ex1.printStackTrace();
      }
    }
  }

  /**
   * 主方法。用于检测本类工作是否正常
   * @param args String[] 运行时参数
   */
  public static void main(String[] args) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection();
      if (conn == null) {
        System.out.println("获得数据库连接错误.");
      } else {
        System.out.println("正常获得数据库连接 == " + conn);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      closeConnection(conn);
    }
  }
}
