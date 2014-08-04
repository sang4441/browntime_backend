package com.springapp.mvc.controller;

import com.springapp.mvc.DAO.CategoryDAO;
import com.springapp.mvc.DAO.MenuDAO;
import com.springapp.mvc.DAO.OrderDAO;
import com.springapp.mvc.DAO.UserDAO;
import com.springapp.mvc.model.BrownCategory;
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
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "")
    public String home(Model model) {
        model.addAttribute("message", "hello");
        return "hello";
    }

    @RequestMapping(value = "/getOrder", produces="application/json")
	public @ResponseBody
    List<BrownOrder> getOrder(ModelMap model) {
        List<BrownOrder> orders = orderDAO.getOrdersBySellerId(1);
		return orders;
	}

    @RequestMapping(value = "/getOrderByPhone/{phoneNum}", produces="application/json")
	public @ResponseBody
    List<BrownOrder> getOrderByPhone (ModelMap model,  @PathVariable String phoneNum) {

        List<BrownOrder> orders = orderDAO.getOrdersByPhoneNum(Integer.parseInt(phoneNum));
		return orders;
	}

    @RequestMapping(value = "/updateOrderDuration/{orderId}/{duration}", produces="application/json")
	public @ResponseBody
    void updateOrderDuration (ModelMap model,  @PathVariable String orderId, @PathVariable String duration) {

        int orderIdInt = Integer.parseInt(orderId);
        int durationInt = Integer.parseInt(duration);
        orderDAO.updateOrderDuration(orderIdInt, durationInt);
	}

    @RequestMapping(value = "/updateOrderStatus/{orderId}/{statusId}", produces="application/json")
	public @ResponseBody
    void updateOrderStatusToComplete (ModelMap model,  @PathVariable String orderId, @PathVariable String statusId) {
        int orderIdInt = Integer.parseInt(orderId);
        int statusIdInt = Integer.parseInt(statusId);
        orderDAO.updateOrderStatus(orderIdInt, statusIdInt);
	}

    @RequestMapping(value = "/requestSMS/{phoneNum}", produces="application/json")
	public @ResponseBody
    void updateOrderStatusToComplete (ModelMap model,  @PathVariable String phoneNum) {
        int phoneNumInt = Integer.parseInt(phoneNum);
        userDAO.updateUserSMS(phoneNumInt);
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

    @RequestMapping(value = "/getCategories/{sellerId}", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<BrownCategory> getCategories(ModelMap model, @PathVariable String sellerId) {
        List<BrownCategory> categories = categoryDAO.getCategoriesBySellerId(Integer.parseInt(sellerId));
        return categories;
    }
}