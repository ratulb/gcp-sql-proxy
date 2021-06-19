package com.example.gcp-sql-proxy.controller;

import java.util.*;

import com.example.gcp-sql-proxy.entity.Product;
import com.example.gcp-sql-proxy.entity.ProductService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class ProductController {

    @Autowired
    private ProductService service;
    @GetMapping("/products")
    public List<Product> list() {
        System.out.println("The request has come here");

        List<Product> result =  service.listAll();
        for(Product p: result){
            p.setName(p.getName().toUpperCase(Locale.ROOT));
        }
        return result;
        //return service.listAll();
    }
    // RESTful API methods for Retrieval operations
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for Create operation

    // RESTful API method for Update operation

    // RESTful API method for Delete operation
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    @PostMapping("/products")
    public void add(@RequestBody Product product) {
        service.save(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
        try {
            Product existProduct = service.get(id);
            service.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/")
    public String home() {
        return "Hi - this is Ratul : "+  new java.util.Date().toString();
    }
}
