package com.tchokoapps.springboot.springcorespringmvc.services;

import com.tchokoapps.springboot.springcorespringmvc.domain.Product;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
public class ProductServiceJpaDaoImpl implements ProductServiceJpaDao {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<?> listAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("from Product", Product.class).getResultList();
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Product getById(Long id) {
        EntityManager em = getEntityManager();
        return em.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Product savedProduct = em.merge(domainObject);
        em.getTransaction().commit();
        return savedProduct;
    }

    @Override
    public void delete(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }
}
