package myshop;

/**
 * ��Ʒ�����Ϣ��
 */
public class Category {
  /** ��Ʒ���ID */
  private int id;

  /** ��Ʒ������� */
  private String name;


  /** �չ��췽�� */
  public Category() {
  }

  /**
   * ���췽��
   * @param id int ��Ʒ���ID
   * @param name String ��Ʒ�������
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
