/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.model;

import java.time.LocalDateTime;

/**
 *
 * @author user
 */
public class Reservation {

    private Long id;
    private LocalDateTime date;
    private Clinic clinic;
    private User user;
    private Visit visit;
    private String animalType;

}
