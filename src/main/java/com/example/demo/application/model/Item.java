package com.example.demo.application.model;

public class Item {
  private int id;
  private String name;
  private int price;

  public Item(int id, String name, int price) {
      setId(id);
      setName(name);
      setPrice(price);
  }

  public String getName() {
      return this.name;
  }

  private void setName(String name) {
      this.name = name;
  }

  public int getPrice() {
      return this.price;
  }

  private void setPrice(int price) {
      this.price = price;
  }

  public int getId() {
      return this.id;
  }

  private void setId(int id) {
      this.id = id;
  }
}
