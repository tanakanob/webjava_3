package com.example.demo.application.view;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.application.model.Item;
import com.example.demo.application.model.form.ListForm;

public class ListView extends ModelAndView {
  private String ATTRIBUTE_NAME_MESSAGE        = "message";
  private String ATTRIBUTE_NAME_CART_ITEM_NUM  = "cartItemNumMessage";
  private String ATTRIBUTE_NAME_ITEMS          = "items";
  private String ATTRIBUTE_NAME_LIST_FORM      = "listForm";

  private String VIEW_NAME = "itemlist";

  public ListView(String message, int cartItemNum, ListForm listForm, List<Item> items) {
      if (message != null && !message.isEmpty()) {
          this.addObject(ATTRIBUTE_NAME_MESSAGE, message);
      }

      StringBuilder cartItemNumBuf = new StringBuilder();
      cartItemNumBuf.append(cartItemNum);
      cartItemNumBuf.append("点の商品がカートに入っています。");
      this.addObject(ATTRIBUTE_NAME_CART_ITEM_NUM, cartItemNumBuf.toString());

      this.addObject(ATTRIBUTE_NAME_ITEMS, items);
      this.addObject(ATTRIBUTE_NAME_LIST_FORM, listForm);

      this.setViewName(VIEW_NAME);
  }
}
