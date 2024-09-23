/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author user
 */
@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor extends Anagrafica {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Clinic clinic;
    @Column(unique = true, nullable = false)
    private String email;

    public Doctor(Long id, String name, String surname, String gender, String phone, String email, String password) {
        super(name, surname, gender, phone);
        this.id = id;
        this.email = email;

    }

}
