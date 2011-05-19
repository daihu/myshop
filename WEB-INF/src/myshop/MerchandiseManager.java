package myshop;

import java.util.Iterator;

import myshop.db.DBMerchandise;

/**
 * 本类用于对商品的相关操作。通过访问静态方法进行相关操作
 */
public abstract class MerchandiseManager {
  /** 私有空构造方法。保证本类不能够被实例化 */
  private MerchandiseManager() {
  }

  /**
   * 添加商品
   * @param m Merchandise 需要添加的商品。要求已经填充各个属性。
   */
  public static void addMerchandise(Merchandise m) {
    if (m.getName() == null || m.getName().trim().length() == 0) {
      // 名称未设置。抛出异常。
      throw new IllegalArgumentException(
        " Merchandise name is null or empty.");
    } else {
      // 向数据库中保存商品
      DBMerchandise.addMerchandise(m);
    }
  }

  /**
   * 获得全部商品
   * @return Iterator 商品的迭代器
   */
  public static Iterator getAllMerchandise() {
    return DBMerchandise.getAllMerchandise();
  }

  /**
   * 获得指定类别下的商品集合
   * @param c Category 商品类别
   * @return Iterator 商品集合
   */
  public static Iterator getMerchandises(Category c) {
    return DBMerchandise.getMerchandises(c);
  }

  /**
   * 修改商品的属性。目前只实现了修改名称。
   * @param m Merchandise 已经填充新属性的商品包装类。
   */
  public static void updateMerchandise(Merchandise m) {
    DBMerchandise.updateMerchandise(m);
  }

  /**
   * 获得指定ID的商品对象
   * @param id int 商品ID
   * @return Category 商品对象。如果指定ID的商品不存在返回null
   */
  public static Merchandise getMerchandise(int id) {
    return DBMerchandise.getMerchandise(id);
  }

  /**
   * 删除指定ID的商品
   * @param id int 商品ID
   */
  public static void deleteMerchandise(int id) {
    DBMerchandise.deleteMerchandise(id);
  }

  /**
   * 得到指定页码的内容
   * @param page int 页数
   * @return Iterator 内容
   * @param c Category 商品类别
   */
  public static Iterator getOnePageMerchandise(Category c,int page) {
    return DBMerchandise.getOnePageMerchandise(c, page);
  }

  /**
   * 返回指定商品类别在指定的每页数量下的最大页号
   * @param c Category 商品类别
   * @return int 最大页号
   */
  public static int getMaxPageNumber(Category c) {
    return DBMerchandise.getMaxPageNumber(c);
  }
}
