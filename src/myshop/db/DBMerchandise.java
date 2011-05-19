package myshop.db;

import myshop.Merchandise;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import myshop.Category;

public abstract class DBMerchandise {
  private DBMerchandise() {
  }

  // 定义每页显示数量的常量。有助于将数据和程序逻辑分离。
  private static int pageSize = 3;

  /**
   * 获得每页显示数量
   * @return int
   */
  public static int getPageSize() {
    return pageSize;
  }

  /**
   * 设置每页显示数量
   * @param pageSize 每页显示数量
   */
  public static void setPageSize(int pageSize) {
    DBMerchandise.pageSize = pageSize;
  }

  /**
   * 向数据库中添加商品
   * @param m Merchandise 需要添加的商品类别。要求已经检验过名称属性的合法性。
   */
  public static void addMerchandise(Merchandise m) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // 获得数据库连接
      PreparedStatement ps = conn.prepareStatement( // 建立PreparedStatement用于执行SQL操作
        "INSERT INTO MERCHANDISE(NAME,PRICE,ADD_TIME,CATEGORY_ID) VALUES(?,?,?,?)");
      ps.setString(1, m.getName());
      ps.setInt(2, m.getPrice());
      // 使用Timestamp对应数据库日期时间字段类型
      ps.setTimestamp(3, new Timestamp(m.getAddTime().getTime()));
      ps.setInt(4, m.getCategoryId());
      ps.execute(); // 执行SQL命令
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
  }

  /**
   * 获得全部商品名称
   * @return Iterator 商品名称的迭代器
   */
  public static Iterator getAllMerchandise() {
    List l = new ArrayList(); //容器类。用于存放所有符合条件的对象。
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // 获得数据连接
      PreparedStatement ps = conn.prepareStatement( // 建立Statement用于执行SQL操作
        "SELECT ID, NAME,PRICE,ADD_TIME,CATEGORY_ID FROM MERCHANDISE");
      ResultSet rs = ps.executeQuery(); // 执行SQL命令
      while (rs.next()) {
        l.add(new Merchandise(rs.getInt(1), rs.getString(2), rs.getInt(3),
                              rs.getTimestamp(4), rs.getInt(5)));
      }
      rs.close();
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
    return l.iterator();
  }

  /**
   * 获得一页内容数量的商品列表
   * @param page int 当前所在页数。第一页从“1”开始
   * @param c Category 商品类别
   * @return Iterator 商品列表
   */
  public static Iterator getOnePageMerchandise(Category c, int page) {
    List l = new ArrayList(); //容器类。用于存放所有符合条件的对象。
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // 获得数据连接

      int total = DBMerchandise.getCounter(c); //存储结果集的总数

      PreparedStatement ps = conn.prepareStatement( // 建立Statement用于执行SQL操作
        "SELECT ID, NAME,PRICE,ADD_TIME,CATEGORY_ID FROM MERCHANDISE "+
        "WHERE CATEGORY_ID=? ORDER BY ID");
      ps.setInt(1, c.getId()); // 设定要查询的类别ID
      ResultSet rs = ps.executeQuery(); // 执行SQL命令
      int t = (page - 1) * pageSize + 1; // 将要开始的结果集行数
      if (t <= total) { // 判断最大边界
        rs.absolute(t); // 将结果集游标移动到指定行数
        do {
          //创建商品对象。并将对象存放到存储集合中。
          l.add(new Merchandise(rs.getInt(1), rs.getString(2), rs.getInt(3),
                                rs.getTimestamp(4), rs.getInt(5)));
        } while (rs.next() && l.size() < pageSize);
      }
      rs.close();
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
    return l.iterator();
  }

  /**
   * 修改商品名称的属性。
   * @param m Merchandise 已经填充新属性的商品名称包装类。
   */
  public static void updateMerchandise(Merchandise m) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // 获得数据连接

      // 使用PreparedStatement更新数据。
      // 每个"?"代表一个占位符，在执行之前要一一设置各占位符的内容
      PreparedStatement ps = conn.prepareStatement(
        "UPDATE MERCHANDISE SET NAME=?,PRICE=?,ADD_TIME=?,CATEGORY_ID=? WHERE ID=?");

      // 设置第一个占位符的内容。设置内容类型为String
      ps.setString(1, m.getName());
      // 设置第二个占位符的内容。设置内容类型为int
      ps.setInt(2, m.getPrice());
      // 设置第三个占位符的内容。设置内容类型为Timestamp
      ps.setTimestamp(3, new Timestamp(m.getAddTime().getTime()));
      // 设置第四个占位符的内容。设置内容类型为int
      ps.setInt(4, m.getCategoryId());
      // 设置第五个占位符的内容。设置内容类型为int
      ps.setInt(5, m.getId());
      ps.executeUpdate(); //执行更新操作
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
  }

  /**
   * 获得指定ID的商品名称对象
   * @param id int 商品名称ID
   * @return Merchandise 商品名称对象
   */
  public static Merchandise getMerchandise(int id) {
    Merchandise m = null;
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // 获得数据连接

      // 建立PreparedStatement用于执行SQL操作
      PreparedStatement ps = conn.prepareStatement(
        "SELECT ID, NAME,PRICE,ADD_TIME,CATEGORY_ID FROM MERCHANDISE WHERE ID=?");
      ps.setInt(1, id); // 设置第一个占位符的内容
      ResultSet rs = ps.executeQuery(); // 执行SQL命令
      if (rs.next()) { //因为每个类别的ID是唯一的，所以只返回一个结果既可
        m = new Merchandise(rs.getInt(1), rs.getString(2), rs.getInt(3),
                            rs.getTimestamp(4), rs.getInt(5));
      }
      rs.close();
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
    return m;
  }

  /**
   * 删除指定ID的商品类别
   * @param id int 商品类别ID
   */
  public static void deleteMerchandise(int id) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // 获得数据连接

      // 建立PreparedStatement用于执行SQL操作
      PreparedStatement ps = conn.prepareStatement(
        "DELETE FROM MERCHANDISE WHERE ID=?");
      ps.setInt(1, id); // 设置第一个占位符的内容
      ps.executeUpdate();
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
  }

  /**
   * 获得指定类别下的商品集合
   * @param c Category 商品类别
   * @return Iterator 商品集合
   */
  public static Iterator getMerchandises(Category c) {
    List l = new ArrayList(); //容器类。用于存放所有符合条件的对象。
    Connection conn = null;
    try {
      if(c != null) {
        conn = ConnectionManager.getConnection(); // 获得数据连接
        PreparedStatement ps = conn.prepareStatement( // 建立Statement用于执行SQL操作
          "SELECT ID,NAME,PRICE,ADD_TIME,CATEGORY_ID FROM MERCHANDISE " +
          "WHERE CATEGORY_ID=?");
        ps.setInt(1, c.getId());
        ResultSet rs = ps.executeQuery(); // 执行SQL命令
        while (rs.next()) {
          l.add(new Merchandise(rs.getInt(1), rs.getString(2), rs.getInt(3),
                                rs.getTimestamp(4), rs.getInt(5)));
        }
        rs.close();
        ps.close();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
    return l.iterator();
  }

  /**
   * 获得指定商品类别下的商品数量
   * @param c Category 商品类别
   * @return int
   */
  public static int getCounter(Category c) {
    int total = 0; //存储结果集的总数
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // 获得数据连接

      // 建立PreparedStatement用于执行SQL操作
      PreparedStatement ps2 = conn.prepareStatement(
        "SELECT COUNT(*) FROM MERCHANDISE WHERE CATEGORY_ID=? ");
      ps2.setInt(1, c.getId()); // 设定要查询的类别ID
      ResultSet rs2 = ps2.executeQuery();
      if (rs2.next()) {
        total = rs2.getInt(1);
      }
      rs2.close();
      ps2.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
    return total;
  }

  /**
   * 返回指定商品类别在指定的每页数量下的最大页号
   * @param c Category 商品类别
   * @return int 最大页号
   */
  public static int getMaxPageNumber(Category c) {
    return DBMerchandise.getCounter(c) % DBMerchandise.pageSize == 0 ?
      DBMerchandise.getCounter(c) / DBMerchandise.pageSize :
      (DBMerchandise.getCounter(c) / DBMerchandise.pageSize) + 1;
  }

  public static void main(String[] args) {
    DBMerchandise.setPageSize(3);
    Category c = DBCategory.getCategory(1);
    boolean b ;
    for (int i=1; i<10; i++) {
      b = false;

      for (Iterator it = DBMerchandise.getOnePageMerchandise(c, i); it.hasNext(); ) {
        System.out.println(((Merchandise) it.next()).getId());
        b = true;
      }
      if (b)
        System.out.println("p"+i+"=="+i);
    }
    System.out.println("maxPage=="+getMaxPageNumber(c));
  }
}
