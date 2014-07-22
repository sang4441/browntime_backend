package com.springapp.mvc.controller;

import com.springapp.mvc.DAO.MenuDAO;
import com.springapp.mvc.DAO.OrderDAO;
import com.springapp.mvc.model.BrownMenu;
import com.springapp.mvc.model.BrownOrder;
import com.springapp.mvc.model.BrownTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import javax.xml.ws.RespectBinding;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/json")
public class JSONController {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    MenuDAO menuDAO;

    @RequestMapping(value = "/getOrder", produces="application/json")
	public @ResponseBody
    List<BrownOrder> getOrder(ModelMap model) {
        List<BrownOrder> orders = orderDAO.getOrdersBySellerId(1);
		return orders;
	}

    @RequestMapping(value = "/addOrder",
            method = RequestMethod.POST,
            headers = "Accept=application/json")
    @ResponseBody
    public BrownOrder createOrderInJSON(@RequestBody BrownOrder order) {
        order.setBuyerId(1);
        order.setStatusId(1);
        order.setTimeRequested(new Date());
        orderDAO.addOrder(order);
        return order;
    }

    @RequestMapping(value = "/getMenus/{sellerId}", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<BrownMenu> getMenus(ModelMap model, @PathVariable String sellerId) {
        List<BrownMenu> menus = menuDAO.getMenusBySellerId(Integer.parseInt(sellerId));
        return menus;
    }

}