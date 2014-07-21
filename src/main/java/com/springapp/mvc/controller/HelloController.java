package com.springapp.mvc.controller;

import com.springapp.mvc.DAO.OrderDAO;
import com.springapp.mvc.model.BrownOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.core.Response;
import javax.xml.ws.RespectBinding;
import java.util.List;

@Controller
@RequestMapping("/json")
public class HelloController {
    @Autowired
    OrderDAO orderDAO;

//    @RequestMapping(method = RequestMethod.GET)
//    public Object printWelcome(ModelMap model) {
////		model.addAttribute("message", "Hello world!");
//        return orderDAO.;
//    }


    @RequestMapping(value = "/order", produces="application/json")
	public @ResponseBody
    BrownOrder printWelcome(ModelMap model) {
//        BrownOrder order = new BrownOrder();
//        order.setId(1);
//        order.setSeller_id(5);

        List<BrownOrder> orders = orderDAO.getOrders();

        BrownOrder order = new BrownOrder();
//        order.setId(1);
        order.setSeller_id(1);
//		model.addAttribute("message",order);
		return order;
	}


    @RequestMapping(value = "/addOrder",
            method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public Response createOrderInJSON(BrownOrder order) {

        String result = "Product created : " + order;

//        return Response.;
        return Response.status(201).entity(result).build();

    }


}