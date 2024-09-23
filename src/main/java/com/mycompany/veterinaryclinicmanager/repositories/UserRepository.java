/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.repositories;

import com.mycompany.veterinaryclinicmanager.model.Role;
import com.mycompany.veterinaryclinicmanager.model.User;

/**
 *
 * @author user
 */
public interface UserRepository {

    public User findById(Long id);

    public User findByUsername(String username);

    public void save(User user);

}
