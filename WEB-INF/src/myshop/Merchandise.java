package myshop;

import java.util.Date;


/**
 * 商品基本信息类
 */
public class Merchandise {
  /** 商品ID */
  private int id;

  /** 商品名称 */
  private String name;

  /** 商品价格。单位为：分 */
  private int price;

  /** 商品上架时间 */
  private Date addTime;

  /** 商品所属类别ID **/
  private int categoryId;

  /** 空构造方法 */
  public Merchandise() {
  }

  /**
   * 构造方法
   * @param id int 商品ID
   * @param name String 商品名称
   * @param price int 商品价格。单位为：分
   * @param addTime Date 商品上架时间
   * @param categoryId int 商品所属类别
   */
  public Merchandise(int id, String name, int price, Date addTime,
                     int categoryId) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.addTime = addTime;
    this.categoryId = categoryId;
  }

  public Date getAddTime() {
    return addTime;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public void setAddTime(Date addTime) {
    this.addTime = addTime;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }
}
