/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.repositories;

import com.mycompany.veterinaryclinicmanager.model.Role;

/**
 *
 * @author user
 */
public interface RoleRepository {

    public void save(Role role);

    public Role findById(Long id);

}
