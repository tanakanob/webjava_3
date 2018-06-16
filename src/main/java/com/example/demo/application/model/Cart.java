package com.example.demo.application.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  private List<Order> orderList = new ArrayList<Order>();

  public List<Order> getOrderList() {
      return this.orderList;
  }

  public void setOrderList(List<Order> orderList) {
      this.orderList = orderList;
  }

  public void add(Order order) {
      // 同じ商品がカートに入っていないかチェックする
      Order existOrder = findOrderByItemId(order.getItem().getItemId());
      if (existOrder == null) {
          // 入っていなかったので新規追加
          orderList.add(order);
      } else {
          // 入っていたので数量を更新
          existOrder.setNum(existOrder.getNum() + order.getNum());
      }
  }

  public boolean remove(Order order) {
      boolean ret = false;
      try {
          ret = orderList.remove(order);
      } catch (Exception e) {}
      return ret;
  }

  public void clear() {
      orderList.clear();
  }

  public int getItemNum() {
      int itemNum = 0;
      for (Order order : orderList) {
          itemNum += order.getNum();
      }
      return itemNum;
  }

  public int getTotalPrice() {
      int totalPrice = 0;
      for (Order order : orderList) {
          totalPrice += order.getSubtotalPrice();
      }
      return totalPrice;
  }

  public Order findOrderByItemId(int itemId) {
      for(Order order : orderList) {
          if(order.getItem().getItemId() == itemId) {
              return order;
          }
      }
      return null;
  }
}
