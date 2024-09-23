/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.model;

import com.mycompany.veterinaryclinicmanager.DayOfWorkOverlapException;
import java.time.LocalTime;
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
    @OneToMany(mappedBy = "clinic")
    private List<Reservation> reservations = new ArrayList<>();
    
    
    
    public void addDayOfWork(DayOfWork dayOfWork) throws Exception {

      for(DayOfWork day: days){
          
          if(day.isOverlap(dayOfWork)){
              throw new DayOfWorkOverlapException("Invalid temporal slot");
          }
      }
      
      days.add(dayOfWork);
    }
     

    
    public static void main(String args[]) throws Exception{
        
        Clinic clinic = new Clinic();
        SlotOfWork slotOfWork = new SlotOfWork(LocalTime.of(8, 30), LocalTime.of(9,30));
        SlotOfWork slotOfWork2 = new SlotOfWork(LocalTime.of(10, 45),LocalTime.of(11,45));
        DayOfWeek dayOfWeek = new DayOfWeek("MONDAY");
        DayOfWork dayOfWork = new DayOfWork(slotOfWork,dayOfWeek, clinic);
        DayOfWork dayOfWork2 = new DayOfWork(slotOfWork2,dayOfWeek, clinic);
        clinic.addDayOfWork(dayOfWork);
        clinic.addDayOfWork(dayOfWork2);
        
        
        
    }

    
}
