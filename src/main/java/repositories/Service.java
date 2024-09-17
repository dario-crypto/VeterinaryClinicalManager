/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import utils.MyEntityManager;

/**
 *
 * @author user
 */
public abstract class Service {

    protected EntityManager entityManager =  Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();

}
