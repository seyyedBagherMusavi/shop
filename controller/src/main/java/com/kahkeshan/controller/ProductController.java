package com.kahkeshan.controller;

import com.kahkeshan.entities.Product;
import com.kahkeshan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    ProductService productService;


    @RequestMapping(value = "/addProduct")
    public String goHome(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "add";
    }

        // For Cart Form.
        // (@ModelAttribute("cartForm") @Validated CartInfo cartForm)
       /* if (target.getClass() == CartInfo.class) {

        }*/
        // For Customer Form.
        // (@ModelAttribute("customerForm") @Validated CustomerInfo
        // customerForm)
     /*   else if (target.getClass() == CustomerInfo.class) {
            dataBinder.setValidator(customerInfoValidator);
        }*/


    @RequestMapping
    public String save(Model model){
        List<Product> productList = productService.selectAll();
        model.addAttribute("productList",productList);
        return "products";
    }
    @RequestMapping(method = RequestMethod.POST,value = "add")
    public String save1(@Valid @ModelAttribute("product")Product product, Model model, BindingResult result){
        if(result.hasErrors()){
            return "add";
        }
        if(product.getId()==0) {
            product.setCreateDate(new Date());
            productService.save(product);
        }else{
            productService.update(product);
        }
        List<Product> productList = productService.selectAll();
        model.addAttribute("productList",productList);
        return "products";
    }



    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("productId") int theId,
                                    Model theModel) {
        Product product = productService.findByCode(theId);
        theModel.addAttribute("product",product);
        return "add";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("productId") int theId,Model model) {
        productService.delete(theId);
        List<Product> productList = productService.selectAll();
        model.addAttribute("productList",productList);

        return "products";
    }


}
