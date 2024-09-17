/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author user
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "days_of_week")
public class DayOfWeek {

    @Id
    @GeneratedValue
    private Long id;

    private String day;
    @OneToOne(mappedBy = "dayOfWeek")
    
    private DayOfWork dayOfWork;

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DayOfWeek other = (DayOfWeek) obj;
        if (!Objects.equals(this.day, other.day)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

}

