package com.shivam.e_commerce.backend.controller;

import com.shivam.e_commerce.backend.entity.Product;
import com.shivam.e_commerce.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    @PostMapping("/add")
    public Product AddProduct(@RequestBody Product product){
        return  productService.addProduct(product);
    }
    @GetMapping("/all")
    public List<Product> GetALlProducts(){
        return productService.GetAllProducts();
    }
    @GetMapping("/{id}")
    public Product GetProductById(@PathVariable Long id){
        return productService.GetProductById(id);
    }
    @PutMapping("/update/{id}")
    public Product UpdateProduct(@PathVariable Long id , @RequestBody Product product){
         return productService.UpdateProduct(id,product);
    }
    @DeleteMapping("/delete/{id}")
    public String DeleteProduct(@PathVariable Long id){
        productService.DeleteProductById(id);
        return "Product Deleted Successfully";
    }
}
