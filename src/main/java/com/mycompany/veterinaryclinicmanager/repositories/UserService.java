/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.repositories;

import com.mycompany.veterinaryclinicmanager.model.Comment;
import com.mycompany.veterinaryclinicmanager.model.Role;
import com.mycompany.veterinaryclinicmanager.model.User;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.veterinaryclinicmanager.utils.MyEntityManager;

/**
 *
 * @author user
 */
public class UserService implements UserRepository {

    private static UserService userService;
    private BaseService baseService;

    private UserService(BaseService baseService) {
        this.baseService = baseService;

    }

    public static UserService getInstance(BaseService baseService) {
        if (userService == null) {
            userService = new UserService(baseService);
        }

        return userService;

    }

    @Override
    public User findById(Long id) {
        EntityManager entityManager = baseService.createEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }

    public void update(Long id, User user) {
        EntityTransaction transaction = null;
        EntityManager entityManager = null;

        try {

            entityManager = baseService.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            User u = entityManager.find(User.class, id);
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Rollback in caso di errore
            }
            ex.printStackTrace(); // Stampa l'errore per il debug

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }

        }

    }

    @Override
    public User findByUsername(String username
    ) {

        EntityManager entityManager = baseService.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root).where(cb.equal(root.get("email"), username));
        TypedQuery<User> query = entityManager.createQuery(cr);

        User user = null;
        try {
            user = query.getSingleResult();
        } catch (NoResultException ex) {
            // Nessun utente trovato
            ex.printStackTrace();
        } catch (NonUniqueResultException ex) {
            // Più di un utente trovato
            ex.printStackTrace();
        } catch (Exception ex) {
            // Altri tipi di eccezioni
            ex.printStackTrace();
        }
        entityManager.close(); // Assicurati di chiudere l'EntityManager

        if (entityManager != null) {
            entityManager.close();
        }

        return user;
    }

    public void removeById(Long id) {
        EntityManager entityManager = baseService.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void save(User user) {
        /*
        EntityManager entityManager = baseService.createEntityManager();
        Session session = (Session) entityManager.getDelegate();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
         */

        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = baseService.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Rollback in caso di errore
            }
            ex.printStackTrace();

        }
        if (entityManager != null) {
            entityManager.close();
        }

    }

    public static void main(String args[]) {
        //UserService us = userService.getInstance();
        //addUsers();

        /*

       
        User user = new User();
        user.setName("pippo");
        user.setEmail("pippo@gmail.com");
        user.setGender("M");
        user.setPassword("pippo");
        RoleRepository roleRepository = RoleService.getInstance();
       // Role role = roleRepository.findById(3L);
        Role role = new Role("ADMIN");
        user.addRole(role);
        us.save(user);
         */
        //User user = us.findById(752L);
        //System.out.println(user.getEmail());
    }

}
