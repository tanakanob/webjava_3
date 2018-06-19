package com.example.demo.application.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.application.model.Cart;

public class BaseController {
  @Autowired
  private HttpSession session;

  private final String KEY_SESSION_MESSAGE = "message";
  private final String KEY_SESSION_CART    = "cart";

  /**
   * カート情報をセッションから取得
   * @return
   */
  protected Cart getCartFromSession() {
      Cart cart = (Cart)session.getAttribute(KEY_SESSION_CART);
      if(cart == null) {
          cart = new Cart();
          setCartFromSession(cart);
      }
      return cart;
  }

  /**
   * カート情報をセッションに保存
   *
   * @param cart
   */
  protected void setCartFromSession(Cart cart) {
      session.setAttribute(KEY_SESSION_CART, cart);
  }

  /**
   * メッセージをセッションから取得
   * @return
   */
  protected String getMessageFromSession() {
      return (String) session.getAttribute(KEY_SESSION_MESSAGE);
  }

  /**
   * メッセージをセッションに保存
   * @param message
   */
  protected void setMessageFromSession(String message) {
      session.setAttribute(KEY_SESSION_MESSAGE, message);
  }

  /**
   * メッセージをセッションから削除
   */
  protected void removeMessageFromSession() {
      session.removeAttribute(KEY_SESSION_MESSAGE);
  }
}
