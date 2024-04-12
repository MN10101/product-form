package com.example.productform.controller;

import com.example.productform.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @GetMapping("/order")
    public String showOrderForm(Model model) {
        model.addAttribute("product", new Product());
        return "orderForm";
    }
    @PostMapping("/submitOrder")
    public String submitOrder(@ModelAttribute("product") @Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "orderForm";
        }
        model.addAttribute("product", product);
        return "confirmation";
    }
}
