package myshop;

import java.util.Date;


/**
 * ��Ʒ������Ϣ��
 */
public class Merchandise {
  /** ��ƷID */
  private int id;

  /** ��Ʒ���� */
  private String name;

  /** ��Ʒ�۸񡣵�λΪ���� */
  private int price;

  /** ��Ʒ�ϼ�ʱ�� */
  private Date addTime;

  /** ��Ʒ�������ID **/
  private int categoryId;

  /** �չ��췽�� */
  public Merchandise() {
  }

  /**
   * ���췽��
   * @param id int ��ƷID
   * @param name String ��Ʒ����
   * @param price int ��Ʒ�۸񡣵�λΪ����
   * @param addTime Date ��Ʒ�ϼ�ʱ��
   * @param categoryId int ��Ʒ�������
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
