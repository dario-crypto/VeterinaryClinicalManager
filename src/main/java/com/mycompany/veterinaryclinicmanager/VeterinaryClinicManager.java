/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.veterinaryclinicmanager;

import com.mycompany.veterinaryclinicmanager.model.User;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import com.mycompany.veterinaryclinicmanager.repositories.BaseService;
import com.mycompany.veterinaryclinicmanager.repositories.UserRepository;
import com.mycompany.veterinaryclinicmanager.repositories.UserService;

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

        UserService userService = UserService.getInstance(new BaseService());

        User user = new User( "Luigi", "Rossi", "M", "0432423432", "luigi@gmail.com", "luigi");
        //user.setId(2L);
        System.out.println(user.getEmail());
       // userService.save(user);
        

    }
}
