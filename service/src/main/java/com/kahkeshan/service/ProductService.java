package com.kahkeshan.service;

import com.kahkeshan.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    public void save(Product product);
    public void update(Product product);
    public void delete(int id);
    public List<Product> selectAll();
    public Product findByCode(int code);
}
