package com.gb.market.gbmarket.controllers;

import com.gb.market.gbmarket.entities.Product;
import com.gb.market.gbmarket.exceptions.ResourceNotFoundException;
import com.gb.market.gbmarket.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public String showAllProducts(Model model, @RequestParam(defaultValue = "1", name = "p") Integer page) {
        if (page < 1) {
            page = 1;
        }
        model.addAttribute("products", productService.findAll(page - 1, 5));
        return "products";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Product getOneProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't exists"));
    }

    @GetMapping("/min/{id}")
    public String filterMinId(Model model, @PathVariable Long id) {
        model.addAttribute("products", productService.filterByMinId(id));
        return "products";
    }
//Этот принт в ветке tmp
    @GetMapping("/max/{id}")
    public String filterMaxId(Model model, @PathVariable Long id) {
        model.addAttribute("products", productService.filterByMaxId(id));
        return "products";
    }

    //Не понятно почему тут закольцовка на 1-м id
    @GetMapping("/jsonMax/{id}")
    @ResponseBody
    public List<Product> filterMaxIdJSON(Model model, @PathVariable Long id) {
        return productService.filterByMaxId(id);
    }
}
