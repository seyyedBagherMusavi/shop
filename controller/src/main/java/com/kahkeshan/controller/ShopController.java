package com.kahkeshan.controller;

import com.kahkeshan.entities.OrderInfos;
import com.kahkeshan.entities.Product;
import com.kahkeshan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = { "/", "/home" })
@SessionAttributes("orderObj")
public class ShopController {
    @Autowired
    ProductService productService;
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {

        model.addAttribute("orderObj", new OrderInfos());
        List<Product> productList = productService.selectAll();
        Integer quantity =0;
        model.addAttribute("productList",productList);
        return "welcome";
    }
    @RequestMapping("/addProduct")
    public String addProduct(@Valid @ModelAttribute("productId")int productid,@Valid @ModelAttribute("quantity")Integer quantity,ModelMap model
    ,@SessionAttribute("orderObj") OrderInfos orderInfos){
        Product product = productService.findByCode(productid);
        orderInfos.addProduct(product,quantity);
        List<Product> productList = productService.selectAll();
        model.addAttribute("productList",productList);
        return "welcome";
    }
    @RequestMapping(value = { "/productImage" }, method = RequestMethod.GET)
    public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
                             @RequestParam("id") int id) throws IOException {
        Product product = null;
        if (id != 0) {
            product = productService.findByCode(id);
        }
        if (product != null && product.getImage() != null) {
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(product.getImage());
        }
        response.getOutputStream().close();
    }

}
