package com.kahkeshan.dao;

import com.kahkeshan.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDao  {
    public void save(Product product);
    public void update(Product product);
    public void delete(int id);
    public List<Product> selectAll();
    public Product findByCode(int id);
}
