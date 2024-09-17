/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime date;
    private int vote;
    @ManyToOne
    private Clinic clinic;
    @ManyToOne
    private User user;
    private static final int MIN_VOTE = 0;
    private static final int MAX_VOTE = 5;

    public void setVote(int vote) {

        if (isValid(vote)) {
            this.vote = vote;
        } else {
            throw new IllegalArgumentException("Il voto deve essere compreso tra 0 e 5");
        }

    }

    public static boolean isValid(int vote) {
        return vote >= MIN_VOTE && vote <= MAX_VOTE;
    }

    public void setTimestamp(LocalDateTime date) {
        this.date = date;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
