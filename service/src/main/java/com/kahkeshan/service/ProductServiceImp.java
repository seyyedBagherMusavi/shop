package com.kahkeshan.service;

import com.kahkeshan.dao.ProductDao;
import com.kahkeshan.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    ProductDao productDao;
    @Override
    @Transactional
    public void save(Product product) {
        if (product.getFileData() != null) {
            byte[] image = new byte[0];
            try {
                image = product.getFileData().getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (image != null && image.length > 0) {
                product.setImage(image);
            }
        }
        productDao.save(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        try {
        if (product.getFileData() != null&&product.getFileData().getBytes().length>0) {
            byte[] image = new byte[0];

                image = product.getFileData().getBytes();

            if (image != null && image.length > 0) {
                product.setImage(image);
            }
        }else{
            Product p=productDao.findByCode(product.getId());
            if(p!=null&&p.getImage()!=null){
                product.setImage(p.getImage());
            }
        }} catch (IOException e) {
                e.printStackTrace();
            }

        productDao.update(product);
    }

    @Override
    @Transactional
    public void delete(int id) {
        productDao.delete(id);
    }

    @Override
    @Transactional
    public List<Product> selectAll() {
        return productDao.selectAll();
    }

    @Override
    @Transactional
    public Product findByCode(int code) {
        return productDao.findByCode(code);
    }
}
