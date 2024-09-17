/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.model;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author user
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "clinics")
public class Clinic {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String partitaIva;
    private String description;
    @OneToMany(mappedBy = "clinic")
    private List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "clinic")
    private List<Doctor> doctors = new ArrayList<>();
    @OneToMany(mappedBy = "clinic")
    private List<Vote> votes = new ArrayList<>();
    @OneToMany(mappedBy = "clinic")
    private List<Visit> visites = new ArrayList<>();
    @OneToMany(mappedBy = "clinic")
    private List<DayOfWork> days = new ArrayList<>();
    /*
    public void addDayOfWork(DayOfWork dayOfWork) {

        if (!dayOfWork.checkOverlap(days)) {
            days.add(dayOfWork);
            dayOfWork.setClinic(this);
        } else {
            //lancia eccezione
        }

    }
     */


    
}
