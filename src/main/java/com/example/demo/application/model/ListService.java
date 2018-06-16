package com.example.demo.application.model;

import java.util.ArrayList;
import java.util.List;

public class ListService {
  private List<Item> itemList = new ArrayList<Item>();

  public ListService() {
//      itemList.add(new Item(1, "AAAAA",100));
//      itemList.add(new Item(2, "BBBBB",200));
//      itemList.add(new Item(3, "CCCCC",300));
//      itemList.add(new Item(4, "DDDDD",400));
//      itemList.add(new Item(5, "EEEEE",500));
//      itemList.add(new Item(6, "FFFFF",600));
//      itemList.add(new Item(7, "GGGGG",700));
//      itemList.add(new Item(8, "HHHHH",800));
//      itemList.add(new Item(9, "IIIII",900));
//      itemList.add(new Item(10, "JJJJJ",1000));
//      itemList.add(new Item(11, "KKKKK",1100));
//      itemList.add(new Item(12, "LLLLL",1200));
//      itemList.add(new Item(13, "MMMMM",1300));
//      itemList.add(new Item(14, "NNNNN",1400));
//      itemList.add(new Item(15, "OOOOO",1500));
//      itemList.add(new Item(16, "PPPPP",1600));
//      itemList.add(new Item(17, "QQQQQ",1700));
//      itemList.add(new Item(18, "RRRRR",1800));
//      itemList.add(new Item(19, "SSSSS",1900));
//      itemList.add(new Item(20, "TTTTT",2000));
//      itemList.add(new Item(21, "UUUUU",2100));
//      itemList.add(new Item(22, "VVVVV",2200));
//      itemList.add(new Item(23, "WWWWW",2300));
//      itemList.add(new Item(24, "XXXXX",2400));
//      itemList.add(new Item(25, "YYYYY",2500));
//      itemList.add(new Item(26, "ZZZZZ",2600));
  }

  public List<Item> getItemList() {
      return itemList;
  }

  public Item findItemById(int id) {
      for (Item item : itemList) {
          if (item.getItemId() == id) return item;
      }
      return null;
  }
}
