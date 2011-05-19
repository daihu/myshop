package myshop;

import java.util.Iterator;

import myshop.db.DBCategory;

/**
 * �������ڶ���Ʒ������ز�����ͨ�����ʾ�̬����������ز���
 */
public abstract class CategoryManager {
  /** ˽�пչ��췽������֤���಻�ܹ���ʵ���� */
  private CategoryManager() {
  }

  /**
   * �����Ʒ���
   * @param c Category ��Ҫ��ӵ���Ʒ���Ҫ���Ѿ�������ĸ������ԡ�
   */
  public static void addCategory(Category c) {
    if (c.getName() == null || c.getName().trim().length() == 0) {
      // ���������δ���á��׳��쳣��
      throw new IllegalArgumentException(
        " Category name is null or empty.");
    } else {
      // �����ݿ��б�����Ʒ���
      DBCategory.addCategory(c);
    }
  }

  /**
   * ���ȫ����Ʒ����
   * @return Iterator ��Ʒ����ĵ�����
   */
  public static Iterator getAllCategory() {
    return DBCategory.getAllCategory();
  }

  /**
   * �޸���Ʒ�������ԡ�Ŀǰֻʵ�����޸����ơ�
   * @param c Category �Ѿ���������Ե���Ʒ����װ�ࡣ
   */
  public static void updateCategory(Category c) {
    DBCategory.updateCategory(c);
  }

  /**
   * ���ָ��ID����Ʒ������
   * @param id int ��Ʒ���ID
   * @return Category ��Ʒ���������ָ��ID����Ʒ��𲻴��ڷ���null
   */
  public static Category getCategory(int id) {
    return DBCategory.getCategory(id);
  }

  /**
   * ɾ��ָ��ID����Ʒ���
   * @param id int ��Ʒ���ID
   */
  public static void deleteCategory(int id) {
    DBCategory.deleteCategory(id);
  }
}
