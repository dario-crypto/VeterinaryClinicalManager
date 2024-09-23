/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author user
 */
@MappedSuperclass
@Getter
@Setter
public class Anagrafica {

    private String name;
    private String surname;
    private String gender;
    private String phone;



    public Anagrafica() {

    }

    public Anagrafica(String name, String surname, String gender, String phone) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.phone = phone;
       
       
    }

 
}
