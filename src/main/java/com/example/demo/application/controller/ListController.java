package com.example.demo.application.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.application.model.Cart;
import com.example.demo.application.model.Item;
import com.example.demo.application.model.Order;
import com.example.demo.application.model.form.ListForm;
import com.example.demo.application.view.ListView;

@Controller
public class ListController extends BaseController {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @RequestMapping(value="/itemlist", method = RequestMethod.GET)
    public ModelAndView show(/*ModelAndView mav*/) {
        String message = getMessageFromSession();
        removeMessageFromSession();

        Cart cart = getCartFromSession();

        ModelAndView mav = new ListView(message, cart.getItemNum(), new ListForm(), getItemList());
        return mav;
    }

    @RequestMapping(value="/itemlist", method = RequestMethod.POST)
    private ModelAndView order(/*ModelAndView mav, */@Valid ListForm listForm, BindingResult bindingResult, HttpServletRequest request) {
        boolean isError = false;
        Item item = null;
        if (bindingResult.getAllErrors().size() > 0) {
            isError = true;
        } else {
            item = getItemByItemId(listForm.getItemId());
        }

        if (isError == true || item == null) {
            // エラー(動作未確認)
            setMessageFromSession("エラーが発生しました。");
            // リダイレクト
            return new ModelAndView("redirect:/itemlist");
        }

        Order order = new Order(item, listForm.getNum());
        Cart cart = getCartFromSession();
        cart.add(order);

        StringBuilder messageBuf = new StringBuilder();
        messageBuf.append(item.getItemName())
            .append("を")
            .append(listForm.getNum())
            .append("点カートに追加しました。");

        // データをセッションへ保存
        setMessageFromSession(messageBuf.toString());
        setCartFromSession(cart);

        // リダイレクト
        return new ModelAndView("redirect:/itemlist");
    }

    /**
     * データベースからアイテムデータ一覧を取得する
     *
     * @return
     */
    public List<Item> getItemList() {
        //SELECTを使用してテーブルの情報をすべて取得する
        List<Item> list = jdbcTemplate.query("SELECT * FROM items ORDER BY item_id", new BeanPropertyRowMapper<Item>(Item.class));

        return list;
    }

    /**
     * データベースからitem_idが一致したアイテムデータを取得する
     *
     * @param itemId
     * @return
     */
    public Item getItemByItemId(int itemId) {
        //SELECTとWHEREを使用してitem_idが引数と一致するものを取得
        List<Item> list = jdbcTemplate.query("SELECT * FROM items WHERE item_id=" + itemId, new BeanPropertyRowMapper<Item>(Item.class));

        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
