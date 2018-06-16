package com.example.demo.application.model;

public class Item {
  private int itemId;
  private String itemName;
  private int itemPrice;

  public Item(int id, String name, int price) {
    setItemId(id);
    setItemName(name);
    setItemPrice(price);
  }

  public Item() {}

  public int getItemId() {
    return this.itemId;
  }

  public void setItemId(int id) {
    this.itemId = id;
  }

  public String getItemName() {
      return this.itemName;
  }

  public void setItemName(String name) {
      this.itemName = name;
  }

  public int getItemPrice() {
      return this.itemPrice;
  }

  public void setItemPrice(int price) {
      this.itemPrice = price;
  }
}
