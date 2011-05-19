package myshop;

import java.util.Iterator;

import myshop.db.DBCategory;

/**
 * 本类用于对商品类别的相关操作。通过访问静态方法进行相关操作
 */
public abstract class CategoryManager {
  /** 私有空构造方法。保证本类不能够被实例化 */
  private CategoryManager() {
  }

  /**
   * 添加商品类别
   * @param c Category 需要添加的商品类别。要求已经填充类别的各个属性。
   */
  public static void addCategory(Category c) {
    if (c.getName() == null || c.getName().trim().length() == 0) {
      // 类别名称是未设置。抛出异常。
      throw new IllegalArgumentException(
        " Category name is null or empty.");
    } else {
      // 向数据库中保存商品类别
      DBCategory.addCategory(c);
    }
  }

  /**
   * 获得全部商品分类
   * @return Iterator 商品分类的迭代器
   */
  public static Iterator getAllCategory() {
    return DBCategory.getAllCategory();
  }

  /**
   * 修改商品类别的属性。目前只实现了修改名称。
   * @param c Category 已经填充新属性的商品类别包装类。
   */
  public static void updateCategory(Category c) {
    DBCategory.updateCategory(c);
  }

  /**
   * 获得指定ID的商品类别对象
   * @param id int 商品类别ID
   * @return Category 商品类别对象。如果指定ID的商品类别不存在返回null
   */
  public static Category getCategory(int id) {
    return DBCategory.getCategory(id);
  }

  /**
   * 删除指定ID的商品类别
   * @param id int 商品类别ID
   */
  public static void deleteCategory(int id) {
    DBCategory.deleteCategory(id);
  }
}
