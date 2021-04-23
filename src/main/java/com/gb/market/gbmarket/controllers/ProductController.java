package com.gb.market.gbmarket.controllers;

import com.gb.market.gbmarket.entities.Product;
import com.gb.market.gbmarket.exceptions.ResourceNotFoundException;
import com.gb.market.gbmarket.services.ProductService;
import com.gb.market.gbmarket.utils.ProductFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public String showAllProducts(Model model,
                                  @RequestParam(defaultValue = "1", name = "p") Integer page,
                                  @RequestParam Map<String, String> params
    ) {
        if (page < 1) {
            page = 1;
        }
        ProductFilter productFilter = new ProductFilter(params);
        Page<Product> products = productService.findAll(productFilter.getSpec(), page - 1, 5);
        model.addAttribute("products", products);
        model.addAttribute("filterDefinition", productFilter.getFilterDefinition());
        return "products";
    }
    //тут наменял
    @GetMapping("/{id}")
    @ResponseBody
    public Product getOneProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't exists"));
    }

  /*  @GetMapping("/min/{id}")
    public String filterMinId(Model model, @PathVariable Long id) {
        model.addAttribute("products", productService.filterByMinId(id));
        return "products";
    }
//Этот принт в ветке tmp
    @GetMapping("/max/{id}")
    public String filterMaxId(Model model, @PathVariable Long id) {
        model.addAttribute("products", productService.filterByMaxId(id));
        return "products";
    }*/
    @GetMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String deleteOneProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "ok";
    }
    // поменял2
}
