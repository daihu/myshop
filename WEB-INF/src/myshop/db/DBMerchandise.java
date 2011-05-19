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

  // ����ÿҳ��ʾ�����ĳ����������ڽ����ݺͳ����߼����롣
  private static int pageSize = 3;

  /**
   * ���ÿҳ��ʾ����
   * @return int
   */
  public static int getPageSize() {
    return pageSize;
  }

  /**
   * ����ÿҳ��ʾ����
   * @param pageSize ÿҳ��ʾ����
   */
  public static void setPageSize(int pageSize) {
    DBMerchandise.pageSize = pageSize;
  }

  /**
   * �����ݿ��������Ʒ
   * @param m Merchandise ��Ҫ��ӵ���Ʒ���Ҫ���Ѿ�������������ԵĺϷ��ԡ�
   */
  public static void addMerchandise(Merchandise m) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // ������ݿ�����
      PreparedStatement ps = conn.prepareStatement( // ����PreparedStatement����ִ��SQL����
        "INSERT INTO MERCHANDISE(NAME,PRICE,ADD_TIME,CATEGORY_ID) VALUES(?,?,?,?)");
      ps.setString(1, m.getName());
      ps.setInt(2, m.getPrice());
      // ʹ��Timestamp��Ӧ���ݿ�����ʱ���ֶ�����
      ps.setTimestamp(3, new Timestamp(m.getAddTime().getTime()));
      ps.setInt(4, m.getCategoryId());
      ps.execute(); // ִ��SQL����
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
  }

  /**
   * ���ȫ����Ʒ����
   * @return Iterator ��Ʒ���Ƶĵ�����
   */
  public static Iterator getAllMerchandise() {
    List l = new ArrayList(); //�����ࡣ���ڴ�����з��������Ķ���
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // �����������
      PreparedStatement ps = conn.prepareStatement( // ����Statement����ִ��SQL����
        "SELECT ID, NAME,PRICE,ADD_TIME,CATEGORY_ID FROM MERCHANDISE");
      ResultSet rs = ps.executeQuery(); // ִ��SQL����
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
   * ���һҳ������������Ʒ�б�
   * @param page int ��ǰ����ҳ������һҳ�ӡ�1����ʼ
   * @param c Category ��Ʒ���
   * @return Iterator ��Ʒ�б�
   */
  public static Iterator getOnePageMerchandise(Category c, int page) {
    List l = new ArrayList(); //�����ࡣ���ڴ�����з��������Ķ���
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // �����������

      int total = DBMerchandise.getCounter(c); //�洢�����������

      PreparedStatement ps = conn.prepareStatement( // ����Statement����ִ��SQL����
        "SELECT ID, NAME,PRICE,ADD_TIME,CATEGORY_ID FROM MERCHANDISE "+
        "WHERE CATEGORY_ID=? ORDER BY ID");
      ps.setInt(1, c.getId()); // �趨Ҫ��ѯ�����ID
      ResultSet rs = ps.executeQuery(); // ִ��SQL����
      int t = (page - 1) * pageSize + 1; // ��Ҫ��ʼ�Ľ��������
      if (t <= total) { // �ж����߽�
        rs.absolute(t); // ��������α��ƶ���ָ������
        do {
          //������Ʒ���󡣲��������ŵ��洢�����С�
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
   * �޸���Ʒ���Ƶ����ԡ�
   * @param m Merchandise �Ѿ���������Ե���Ʒ���ư�װ�ࡣ
   */
  public static void updateMerchandise(Merchandise m) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // �����������

      // ʹ��PreparedStatement�������ݡ�
      // ÿ��"?"����һ��ռλ������ִ��֮ǰҪһһ���ø�ռλ��������
      PreparedStatement ps = conn.prepareStatement(
        "UPDATE MERCHANDISE SET NAME=?,PRICE=?,ADD_TIME=?,CATEGORY_ID=? WHERE ID=?");

      // ���õ�һ��ռλ�������ݡ�������������ΪString
      ps.setString(1, m.getName());
      // ���õڶ���ռλ�������ݡ�������������Ϊint
      ps.setInt(2, m.getPrice());
      // ���õ�����ռλ�������ݡ�������������ΪTimestamp
      ps.setTimestamp(3, new Timestamp(m.getAddTime().getTime()));
      // ���õ��ĸ�ռλ�������ݡ�������������Ϊint
      ps.setInt(4, m.getCategoryId());
      // ���õ����ռλ�������ݡ�������������Ϊint
      ps.setInt(5, m.getId());
      ps.executeUpdate(); //ִ�и��²���
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
  }

  /**
   * ���ָ��ID����Ʒ���ƶ���
   * @param id int ��Ʒ����ID
   * @return Merchandise ��Ʒ���ƶ���
   */
  public static Merchandise getMerchandise(int id) {
    Merchandise m = null;
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // �����������

      // ����PreparedStatement����ִ��SQL����
      PreparedStatement ps = conn.prepareStatement(
        "SELECT ID, NAME,PRICE,ADD_TIME,CATEGORY_ID FROM MERCHANDISE WHERE ID=?");
      ps.setInt(1, id); // ���õ�һ��ռλ��������
      ResultSet rs = ps.executeQuery(); // ִ��SQL����
      if (rs.next()) { //��Ϊÿ������ID��Ψһ�ģ�����ֻ����һ������ȿ�
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
   * ɾ��ָ��ID����Ʒ���
   * @param id int ��Ʒ���ID
   */
  public static void deleteMerchandise(int id) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // �����������

      // ����PreparedStatement����ִ��SQL����
      PreparedStatement ps = conn.prepareStatement(
        "DELETE FROM MERCHANDISE WHERE ID=?");
      ps.setInt(1, id); // ���õ�һ��ռλ��������
      ps.executeUpdate();
      ps.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionManager.closeConnection(conn);
    }
  }

  /**
   * ���ָ������µ���Ʒ����
   * @param c Category ��Ʒ���
   * @return Iterator ��Ʒ����
   */
  public static Iterator getMerchandises(Category c) {
    List l = new ArrayList(); //�����ࡣ���ڴ�����з��������Ķ���
    Connection conn = null;
    try {
      if(c != null) {
        conn = ConnectionManager.getConnection(); // �����������
        PreparedStatement ps = conn.prepareStatement( // ����Statement����ִ��SQL����
          "SELECT ID,NAME,PRICE,ADD_TIME,CATEGORY_ID FROM MERCHANDISE " +
          "WHERE CATEGORY_ID=?");
        ps.setInt(1, c.getId());
        ResultSet rs = ps.executeQuery(); // ִ��SQL����
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
   * ���ָ����Ʒ����µ���Ʒ����
   * @param c Category ��Ʒ���
   * @return int
   */
  public static int getCounter(Category c) {
    int total = 0; //�洢�����������
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection(); // �����������

      // ����PreparedStatement����ִ��SQL����
      PreparedStatement ps2 = conn.prepareStatement(
        "SELECT COUNT(*) FROM MERCHANDISE WHERE CATEGORY_ID=? ");
      ps2.setInt(1, c.getId()); // �趨Ҫ��ѯ�����ID
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
   * ����ָ����Ʒ�����ָ����ÿҳ�����µ����ҳ��
   * @param c Category ��Ʒ���
   * @return int ���ҳ��
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
