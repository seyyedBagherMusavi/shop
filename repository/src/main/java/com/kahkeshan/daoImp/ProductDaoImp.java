package com.kahkeshan.daoImp;

import com.kahkeshan.dao.ProductDao;
import com.kahkeshan.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDaoImp implements ProductDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Product person) {
        sessionFactory.openSession().save(person);
    }

    @Override
    public void update(Product person) {
        sessionFactory.openSession().update(person);
    }

    @Override
    public void delete(String code) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.byId(Product.class).load(code);
        session.delete(product);

    }

    @Override
    public List<Product> selectAll() {
        Query query = sessionFactory.openSession().createQuery("from Product");
        List<Product> persons = query.list();
        return persons;
    }
}
