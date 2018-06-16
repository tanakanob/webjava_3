package com.example.demo.application.view;

import org.springframework.web.servlet.ModelAndView;
import com.example.demo.application.model.Cart;
import com.example.demo.application.model.CartForm;

public class CartView extends ModelAndView {
  private String ATTRIBUTE_NAME_MESSAGE     = "message";
  private String ATTRIBUTE_NAME_CART_CART   = "cart";
  private String ATTRIBUTE_NAME_TOTAL_PRICE = "totalPrice";
  private String ATTRIBUTE_NAME_CART_FORM   = "cartForm";

  private String VIEW_NAME = "cart";

  public CartView(String message, Cart cart, CartForm cartForm) {
      this.addObject(ATTRIBUTE_NAME_MESSAGE, message);
      this.addObject(ATTRIBUTE_NAME_CART_CART, cart);
      this.addObject(ATTRIBUTE_NAME_TOTAL_PRICE, cart.getTotalPrice());
      this.addObject(ATTRIBUTE_NAME_CART_FORM, cartForm);
      this.setViewName(VIEW_NAME);
  }
}
