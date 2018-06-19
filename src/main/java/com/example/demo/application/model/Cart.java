package com.example.demo.application.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  private List<Order> orderList = new ArrayList<Order>();

  /**
   * カート内のオーダ情報を取得
   *
   * @return
   */
  public List<Order> getOrderList() {
      return this.orderList;
  }

  /**
   * カートにオーダー情報を追加
   *
   * @param order
   */
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

  /**
   * カートから指定されたオーダー情報を削除
   *
   * @param order
   * @return
   */
  public boolean remove(Order order) {
      boolean ret = false;
      try {
          ret = orderList.remove(order);
      } catch (Exception e) {}
      return ret;
  }

  /**
   * カートからオーダー情報を一括削除
   */
  public void clear() {
      orderList.clear();
  }

  /**
   * カート内の商品の点数合計を取得
   *
   * @return
   */
  public int getItemNum() {
      int itemNum = 0;
      for (Order order : orderList) {
          itemNum += order.getNum();
      }
      return itemNum;
  }

  /**
   * カート内の商品の合計金額を取得
   *
   * @return
   */
  public int getTotalPrice() {
      int totalPrice = 0;
      for (Order order : orderList) {
          totalPrice += order.getSubtotalPrice();
      }
      return totalPrice;
  }

  /**
   * カート内からitemIdをキーにオーダー情報を取得する
   *
   * @param itemId
   * @return
   */
  public Order findOrderByItemId(int itemId) {
      for(Order order : orderList) {
          if(order.getItem().getItemId() == itemId) {
              return order;
          }
      }
      return null;
  }
}
