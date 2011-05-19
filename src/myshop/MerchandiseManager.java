package myshop;

import java.util.Iterator;

import myshop.db.DBMerchandise;

/**
 * �������ڶ���Ʒ����ز�����ͨ�����ʾ�̬����������ز���
 */
public abstract class MerchandiseManager {
  /** ˽�пչ��췽������֤���಻�ܹ���ʵ���� */
  private MerchandiseManager() {
  }

  /**
   * �����Ʒ
   * @param m Merchandise ��Ҫ��ӵ���Ʒ��Ҫ���Ѿ����������ԡ�
   */
  public static void addMerchandise(Merchandise m) {
    if (m.getName() == null || m.getName().trim().length() == 0) {
      // ����δ���á��׳��쳣��
      throw new IllegalArgumentException(
        " Merchandise name is null or empty.");
    } else {
      // �����ݿ��б�����Ʒ
      DBMerchandise.addMerchandise(m);
    }
  }

  /**
   * ���ȫ����Ʒ
   * @return Iterator ��Ʒ�ĵ�����
   */
  public static Iterator getAllMerchandise() {
    return DBMerchandise.getAllMerchandise();
  }

  /**
   * ���ָ������µ���Ʒ����
   * @param c Category ��Ʒ���
   * @return Iterator ��Ʒ����
   */
  public static Iterator getMerchandises(Category c) {
    return DBMerchandise.getMerchandises(c);
  }

  /**
   * �޸���Ʒ�����ԡ�Ŀǰֻʵ�����޸����ơ�
   * @param m Merchandise �Ѿ���������Ե���Ʒ��װ�ࡣ
   */
  public static void updateMerchandise(Merchandise m) {
    DBMerchandise.updateMerchandise(m);
  }

  /**
   * ���ָ��ID����Ʒ����
   * @param id int ��ƷID
   * @return Category ��Ʒ�������ָ��ID����Ʒ�����ڷ���null
   */
  public static Merchandise getMerchandise(int id) {
    return DBMerchandise.getMerchandise(id);
  }

  /**
   * ɾ��ָ��ID����Ʒ
   * @param id int ��ƷID
   */
  public static void deleteMerchandise(int id) {
    DBMerchandise.deleteMerchandise(id);
  }

  /**
   * �õ�ָ��ҳ�������
   * @param page int ҳ��
   * @return Iterator ����
   * @param c Category ��Ʒ���
   */
  public static Iterator getOnePageMerchandise(Category c,int page) {
    return DBMerchandise.getOnePageMerchandise(c, page);
  }

  /**
   * ����ָ����Ʒ�����ָ����ÿҳ�����µ����ҳ��
   * @param c Category ��Ʒ���
   * @return int ���ҳ��
   */
  public static int getMaxPageNumber(Category c) {
    return DBMerchandise.getMaxPageNumber(c);
  }
}
