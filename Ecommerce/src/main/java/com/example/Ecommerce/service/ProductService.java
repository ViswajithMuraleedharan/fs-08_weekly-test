package com.example.Ecommerce.service;

import com.example.Ecommerce.dao.ProductRepository;
import com.example.Ecommerce.model.Address;
import com.example.Ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAllproducts(){
        List<Product> allProduct=productRepository.findAll();
        return allProduct;
    }
    public List<Product> findProduct(String category){
        List<Product> allProduct=findAllproducts();
        List<Product> selectedProduct;
        if(category!=null){
            return allProduct;
        }
        else{
            selectedProduct=new ArrayList<>();
            for(Product product:allProduct){
                if(product.getCategory().equals(category)){
                    selectedProduct.add(product);
                }
            }
        }
        return selectedProduct;
    }


    public void deleteProduct(Integer product_id){
        productRepository.deleteById(product_id);
    }
}
