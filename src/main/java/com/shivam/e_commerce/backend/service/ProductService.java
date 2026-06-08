package com.shivam.e_commerce.backend.service;

import com.shivam.e_commerce.backend.Repository.ProductRepository;
import com.shivam.e_commerce.backend.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private  final ProductRepository productRepository;


    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    @Cacheable("products")
    public List<Product> GetAllProducts(){
        System.out.println("Fetching from database...");
        return productRepository.findAll();
    }
    public Product GetProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(("Product not Found")));
    }
    public void DeleteProductById(Long id){
        productRepository.deleteById(id);
    }
    public Product UpdateProduct(Long id , Product product){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product Not Found"));

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());

       return productRepository.save(existingProduct);
    }

    public List<Product> Searchproducts(String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }

}
