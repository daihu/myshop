package myshop.db;

import java.sql.*;
import java.util.*;

import myshop.Category;

/**
 * 完成对商品类别的数据库操作
 */
public abstract class DBCategory {
  /** 私有空构造方法。保证本类不能够被实例化 */
  private DBCategory() {
  }

  /**
   * 向数据库中添加商品类别
   * @param c Category 需要添加的商品类别。要求已经检验过类别属性的合法性。
   */
  public static void addCategory(Category c) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // 获得数据连接
      Statement stmt = conn.createStatement(); // 建立Statement用于执行SQL操作
      stmt.executeUpdate("INSERT INTO CATEGORY (NAME) VALUES ('" +
                         c.getName() + "')"); // 执行SQL命令
      stmt.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
  }

  /**
   * 获得全部商品分类
   * @return Iterator 商品分类的迭代器
   */
  public static Iterator getAllCategory() {
    List l = new ArrayList(); //容器类。用于存放所有符合条件的对象。
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // 获得数据连接
      Statement stmt = conn.createStatement(); // 建立Statement用于执行SQL操作
      ResultSet rs = stmt.executeQuery("SELECT ID, NAME FROM CATEGORY"); // 执行SQL命令
      String  s=null;
      while (rs.next()) {
      	s=rs.getString(2);
        l.add(new Category(rs.getInt(1), s));
      }
      stmt.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
    return l.iterator();
  }

  /**
   * 修改商品类别的属性。目前只实现了修改名称。
   * @param c Category 已经填充新属性的商品类别包装类。
   */
  public static void updateCategory(Category c) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // 获得数据连接

      // 使用PreparedStatement更新数据。
      // 每个"?"代表一个占位符，在执行之前要一一设置各占位符的内容
      PreparedStatement ps = conn.prepareStatement("UPDATE CATEGORY SET NAME=? WHERE ID=?");

      // 设置第一个占位符的内容。设置内容类型为String
      ps.setString(1, c.getName());

      // 设置第二个占位符的内容。设置内容类型为int
      ps.setInt(2, c.getId());

      ps.executeUpdate(); //执行更新操作
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
  }

  /**
   * 获得指定ID的商品类别对象
   * @param id int 商品类别ID
   * @return Category 商品类别对象
   */
  public static Category getCategory(int id) {
    Category c = null;
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // 获得数据连接

      // 建立PreparedStatement用于执行SQL操作
      PreparedStatement ps = conn.prepareStatement(
        "SELECT ID, NAME FROM CATEGORY WHERE ID=?");
      ps.setInt(1, id); // 设置第一个占位符的内容
      ResultSet rs = ps.executeQuery(); // 执行SQL命令
      if (rs.next()) { //因为每个类别的ID是唯一的，所以只返回一个结果既可
        c = new Category(rs.getInt(1), rs.getString(2));
      }
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
    return c;
  }

  /**
   * 删除指定ID的商品类别
   * @param id int 商品类别ID
   */
  public static void deleteCategory(int id) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // 获得数据连接

      // 建立PreparedStatement用于执行SQL操作
      PreparedStatement ps = conn.prepareStatement("DELETE FROM CATEGORY WHERE ID=?");
      ps.setInt(1, id); // 设置第一个占位符的内容
      ps.executeUpdate();
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
  }

  public static void main(String[] args) {
	  Category  c1=new Category(12345,"zxf");
	  DBCategory.addCategory(c1);
  }

}
