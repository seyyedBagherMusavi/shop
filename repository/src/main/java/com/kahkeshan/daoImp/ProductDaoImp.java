package com.kahkeshan.daoImp;

import com.kahkeshan.dao.ProductDao;
import com.kahkeshan.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImp implements ProductDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public void update(Product person) {
        sessionFactory.getCurrentSession().update(person);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class,id);
        session.delete(product);

    }

    @Override
    public List<Product> selectAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> persons = query.list();
        return persons;
    }

    @Override
    public Product findByCode(int code) {
        return sessionFactory.openSession().load(Product.class,code);
    }
}
