package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.Address;
import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.ProductService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

   @GetMapping("getallproduct")
   public List<Product> findAllProduct(){
       return productService.findAllproducts();
   }

    @GetMapping("getproductbycategory")
    public List<Product> findProduct(@Nullable @RequestParam String category){
        return productService.findProduct(category);
    }

    @DeleteMapping("deleteproduct")
    public ResponseEntity<String> deleteProduct(@RequestParam Integer prod_id){
        if(prod_id!=null) {
            productService.deleteProduct(prod_id);
            return new ResponseEntity<>("Product deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Please enter valid product id",HttpStatus.BAD_REQUEST);
    }

}
