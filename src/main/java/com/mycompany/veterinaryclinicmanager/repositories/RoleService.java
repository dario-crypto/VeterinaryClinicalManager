/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.repositories;

import com.mycompany.veterinaryclinicmanager.model.Role;
import com.mycompany.veterinaryclinicmanager.model.User;
import java.lang.Long;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.veterinaryclinicmanager.utils.MyEntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author user
 */
public class RoleService implements RoleRepository {

    private static RoleService roleService;
    private BaseService baseService = new BaseService();

    private RoleService(BaseService baseService) {
        this.baseService = baseService;

    }

    public static RoleService getInstance(BaseService baseService) {
        if (roleService == null) {
            roleService = new RoleService(baseService);
        }

        return roleService;
    }

    public Role findByName(String roleName) {
        EntityManager entityManager = baseService.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> cr = cb.createQuery(Role.class);
        Root<Role> root = cr.from(Role.class);
        cr.select(root);
        cr.select(root).where(cb.equal(root.get("role"), roleName));
        TypedQuery<Role> query = entityManager.createQuery(cr);

        Role role = null;

        try {

            role = query.getSingleResult();

        } catch (NoResultException ex) {
            // Nessun utente trovato
            ex.printStackTrace();
        } catch (NonUniqueResultException ex) {
            // Più di un utente trovato
            ex.printStackTrace();
        } catch (Exception ex) {
            // Altri tipi di eccezioni
            ex.printStackTrace();
        } finally {
            entityManager.close(); // Assicurati di chiudere l'EntityManager
        }
        return role;

    }

    @Override
    public void save(Role role) {
        EntityManager entityManager = baseService.createEntityManager();
        EntityTransaction transaction = null;
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(role);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }

        if (entityManager != null) {
            entityManager.close();
        }

    }

    public static void main(String[] args) {
        RoleRepository roleRepo = RoleService.getInstance(new BaseService());

        /*
        Role r1 = new Role("USER");
        Role r2 = new Role("STAFF");
        Role r3 = new Role("ADMIN");
      
        roleRepo.save(r1);
        roleRepo.save(r2);
        roleRepo.save(r3);

         */
        Role role = roleRepo.findById(1L);
        System.out.println("ROLE FOUND: " + role.getRole());

    }

    @Override
    public Role findById(Long id) {
        EntityManager entityManager = baseService.createEntityManager();
        Role role = entityManager.find(Role.class, id);
        entityManager.close();
        return role;
    }

}
