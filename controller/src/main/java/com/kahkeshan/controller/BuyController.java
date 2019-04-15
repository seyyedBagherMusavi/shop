package com.kahkeshan.controller;


import com.kahkeshan.entities.OrderInfos;
import com.kahkeshan.entities.Product;
import com.kahkeshan.entities.User;
import com.kahkeshan.service.UserDetailsServiceImp;
import com.kahkeshan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping(value = { "/buy" })
@SessionAttributes("orderObj")
public class BuyController {
    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:8081/")
    @RequestMapping(method = RequestMethod.GET)
    public String homePage(ModelMap model,@SessionAttribute("orderObj") OrderInfos orderInfos) {
        model.addAttribute("orderObj", orderInfos);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            User user = userService.findUserByUsername(username);
            model.addAttribute("user",user);
        }
        return "buy";
    }
}
