package myshop.db;

import java.sql.*;

/**
 * ���ݿ����ӿ����ࡣͨ�����ʾ�̬����������ݿ�����
 */
public abstract class ConnectionManager {
  /** ������ӳ����� */
  public static final int TYPE_POOLED = 0;

  /** ���ֱ���������� */
  public static final int TYPE_DIRECT = 1;

  /** ˽�пչ��췽������֤���಻�ܹ���ʵ���� */
  private ConnectionManager() {
  }

  /**
   * ���Ĭ�����ӷ�ʽ�����ݿ����ӡ�ĿǰĬ��Ϊ�������ӡ�
   * @return Connection ���ݿ�����
   */
  public static Connection getConnection() {
    return getConnection(TYPE_DIRECT);
  }

  /**
   * ���ָ�����ӷ�ʽ�����ݿ�����
   * @param type int ���ӷ�ʽ <br/>
   * ConnectionManager.TYPE_POOLED ���ݿ����ӳ����� <br/>
   * ConnectionManager.TYPE_DIRECT ֱ����������
   * @return Connection ���ݿ�����
   */
  public static Connection getConnection(int type) {
    Connection conn = null;
    switch (type) {
    case TYPE_DIRECT:
      try {
        // ����JDBC��������
        String driverName = "org.gjt.mm.mysql.Driver"; // MySQL JDBC ������������
        Class.forName(driverName);

        // ���ݿ����Ӳ�����ָ���������ı��뷽ʽ�������ݿ�
        String serverName = "localhost"; // ���ݿ���������
        String mydatabase = "my_shop"; // ���ݿ�����
        // ����url��ָ�����ӷ�ʽΪGBK����
        String url = "jdbc:mysql://" + serverName + "/" +
                     mydatabase +
                     "?useUnicode=true&characterEncoding=GBK";
        String username = "root"; // �����û���
        String password = "111111"; // ��������

        // ������ݿ�����
        conn = DriverManager.getConnection(url, username, password);
      } catch (ClassNotFoundException e) {
        // ���ܹ��ҵ�������
        e.printStackTrace();
      } catch (SQLException e) {
        // ������ݿ����ӷ����쳣
        e.printStackTrace();
      }
      break;
    case TYPE_POOLED:
      throw new UnsupportedOperationException("Now Unsupported.");
    }
    return conn;
  }

  /**
   * �ر����ݿ�����
   * @param conn Connection ��Ҫ���رյ����ݿ�����
   */
  public static void closeConnection(Connection conn) {
    if (conn != null) { //�����Ƿ���Ч
      try {
        if (!conn.isClosed()) { //�����Ƿ��ѹر�
          conn.close(); //�ر�����
        }
      } catch (SQLException ex1) {
        ex1.printStackTrace();
      }
    }
  }

  /**
   * �����������ڼ�Ȿ�๤���Ƿ�����
   * @param args String[] ����ʱ����
   */
  public static void main(String[] args) {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection();
      if (conn == null) {
        System.out.println("������ݿ����Ӵ���.");
      } else {
        System.out.println("����������ݿ����� == " + conn);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      closeConnection(conn);
    }
  }
}
