/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.veterinaryclinicmanager.model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import repositories.UserRepository;
import repositories.UserService;

/**
 *
 * @author user
 */
public class VeterinaryClinicManager {

    public static void main(String[] args) {
        /*
        User user = new User();
        user.setEmail("dario@gmail.com");
        user.setName("dario");
        
        EntityManager em = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
         */

        UserRepository userRepository = UserService.getInstance();
        User user = userRepository.findById(152L);
        System.out.println(user);

    }
}
