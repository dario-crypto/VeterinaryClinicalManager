/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class MyEntityManager {

    public static EntityManager getInstance() {
        return Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    }

}
