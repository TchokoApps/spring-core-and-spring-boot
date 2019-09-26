package com.tchokoapps.springboot.springcorespringmvc.services;

import com.tchokoapps.springboot.springcorespringmvc.domain.User;
import com.tchokoapps.springboot.springcorespringmvc.services.security.EncryptedService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
public class UserServiceJpaDaoImpl implements UserServiceJpaDao {

    private EntityManagerFactory emf;

    private EncryptedService encryptedService;

    public UserServiceJpaDaoImpl(EncryptedService encryptedService) {
        this.encryptedService = encryptedService;
    }

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public List<?> listAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("from User", User.class).getResultList();
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public User getById(Long id) {
        return getEntityManager().find(User.class, id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        if (domainObject.getPassword() != null) {
            domainObject.setEncryptedPassword(encryptedService.encryptString(domainObject.getPassword()));
        }
        User saveduser = em.merge(domainObject);
        em.getTransaction().commit();
        return saveduser;
    }

    @Override
    public void delete(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
    }
}
