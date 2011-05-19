package myshop;

/**
 * 商品类别信息类
 */
public class Category {
  /** 商品类别ID */
  private int id;

  /** 商品类别名称 */
  private String name;


  /** 空构造方法 */
  public Category() {
  }

  /**
   * 构造方法
   * @param id int 商品类别ID
   * @param name String 商品类别名称
   */
  public Category(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
