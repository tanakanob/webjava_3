package com.example.demo.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.application.model.Cart;
import com.example.demo.application.model.Order;
import com.example.demo.application.model.form.CartForm;
import com.example.demo.application.view.CartView;

@Controller
public class CartController extends BaseController {
    @RequestMapping(value="/cart", method = RequestMethod.GET)
    public ModelAndView show(/*ModelAndView mav*/) {
        String message = getMessageFromSession();
        removeMessageFromSession();

        Cart cart = getCartFromSession();

        ModelAndView mav = new CartView(message, cart, new CartForm());
        return mav;
    }

    @RequestMapping(value="/cart", method = RequestMethod.POST)
    private ModelAndView remove(/*ModelAndView mav, */@Valid CartForm cartForm, BindingResult bindingResult, HttpServletRequest request) {
        Cart cart = getCartFromSession();
        Order order = cart.findOrderByItemId(cartForm.getItemId());


        String message;
        if (cart.remove(order)) {
            message = order.getItem().getItemName() + "をカートから削除しました。";
        } else {
            message = "削除処理でエラーが発生しました。";
        }

        // データをセッションへ保存
        setMessageFromSession(message);
        setCartFromSession(cart);

        // リダイレクト
        return new ModelAndView("redirect:/cart");
    }
}