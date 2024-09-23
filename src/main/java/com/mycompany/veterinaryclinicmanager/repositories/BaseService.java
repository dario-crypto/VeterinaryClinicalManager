/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class BaseService {
    
    private EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("persistenceUnit");

    public EntityManager createEntityManager() {
        // l'entity manager non e' thread-safe e quindi non va condiviso tra piu servizi
        return entityFactory.createEntityManager();

    }

}
