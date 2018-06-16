package com.example.demo.application.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.application.model.Cart;

public class BaseController {
  @Autowired
  private HttpSession session;

  private final String KEY_SESSION_MESSAGE = "message";
  private final String KEY_SESSION_CART    = "cart";

  protected Cart getCartFromSession() {
      Cart cart = (Cart)session.getAttribute(KEY_SESSION_CART);
      if(cart == null) {
          cart = new Cart();
          setCartFromSession(cart);
      }
      return cart;
  }

  protected void setCartFromSession(Cart cart) {
      session.setAttribute(KEY_SESSION_CART, cart);
  }

  protected String getMessageFromSession() {
      return (String) session.getAttribute(KEY_SESSION_MESSAGE);
  }

  protected void setMessageFromSession(String message) {
      session.setAttribute(KEY_SESSION_MESSAGE, message);
  }

  protected void removeMessageFromSession() {
      session.removeAttribute(KEY_SESSION_MESSAGE);
  }
}
