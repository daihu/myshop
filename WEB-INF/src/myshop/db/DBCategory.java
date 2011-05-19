package myshop.db;

import java.sql.*;
import java.util.*;

import myshop.Category;

/**
 * ��ɶ���Ʒ�������ݿ����
 */
public abstract class DBCategory {
  /** ˽�пչ��췽������֤���಻�ܹ���ʵ���� */
  private DBCategory() {
  }

  /**
   * �����ݿ��������Ʒ���
   * @param c Category ��Ҫ��ӵ���Ʒ���Ҫ���Ѿ������������ԵĺϷ��ԡ�
   */
  public static void addCategory(Category c) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // �����������
      Statement stmt = conn.createStatement(); // ����Statement����ִ��SQL����
      stmt.executeUpdate("INSERT INTO CATEGORY (NAME) VALUES ('" +
                         c.getName() + "')"); // ִ��SQL����
      stmt.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
  }

  /**
   * ���ȫ����Ʒ����
   * @return Iterator ��Ʒ����ĵ�����
   */
  public static Iterator getAllCategory() {
    List l = new ArrayList(); //�����ࡣ���ڴ�����з��������Ķ���
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // �����������
      Statement stmt = conn.createStatement(); // ����Statement����ִ��SQL����
      ResultSet rs = stmt.executeQuery("SELECT ID, NAME FROM CATEGORY"); // ִ��SQL����
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
   * �޸���Ʒ�������ԡ�Ŀǰֻʵ�����޸����ơ�
   * @param c Category �Ѿ���������Ե���Ʒ����װ�ࡣ
   */
  public static void updateCategory(Category c) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // �����������

      // ʹ��PreparedStatement�������ݡ�
      // ÿ��"?"����һ��ռλ������ִ��֮ǰҪһһ���ø�ռλ��������
      PreparedStatement ps = conn.prepareStatement("UPDATE CATEGORY SET NAME=? WHERE ID=?");

      // ���õ�һ��ռλ�������ݡ�������������ΪString
      ps.setString(1, c.getName());

      // ���õڶ���ռλ�������ݡ�������������Ϊint
      ps.setInt(2, c.getId());

      ps.executeUpdate(); //ִ�и��²���
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
  }

  /**
   * ���ָ��ID����Ʒ������
   * @param id int ��Ʒ���ID
   * @return Category ��Ʒ������
   */
  public static Category getCategory(int id) {
    Category c = null;
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // �����������

      // ����PreparedStatement����ִ��SQL����
      PreparedStatement ps = conn.prepareStatement(
        "SELECT ID, NAME FROM CATEGORY WHERE ID=?");
      ps.setInt(1, id); // ���õ�һ��ռλ��������
      ResultSet rs = ps.executeQuery(); // ִ��SQL����
      if (rs.next()) { //��Ϊÿ������ID��Ψһ�ģ�����ֻ����һ������ȿ�
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
   * ɾ��ָ��ID����Ʒ���
   * @param id int ��Ʒ���ID
   */
  public static void deleteCategory(int id) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // �����������

      // ����PreparedStatement����ִ��SQL����
      PreparedStatement ps = conn.prepareStatement("DELETE FROM CATEGORY WHERE ID=?");
      ps.setInt(1, id); // ���õ�һ��ռλ��������
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
