package com.example.demo.application.model;

public class Order {
  private Item item;
  private int num;

  public Order(Item item, int num) {
      setItem(item);
      setNum(num);
  }

  public Item getItem() {
      return this.item;
  }

  private void setItem(Item item) {
      this.item = item;
  }

  public int getNum() {
      return this.num;
  }

  public void setNum(int num) {
      this.num = num;
  }

  public int getSubtotalPrice() {
      return item.getItemPrice() * num;
  }
}
