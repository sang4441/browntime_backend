package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kimsanghwan on 7/28/2014.
 */

@Controller
@RequestMapping("/")
public class BasicController {
    @RequestMapping(value = "")
    public String home(Model model) {
        model.addAttribute("message", "hello");
        return "hello";
    }
}
