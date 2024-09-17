/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryclinicmanager.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "users")
public class User extends Anagrafica {

    @Id
    @GeneratedValue
    private Long id;
    private String password;
    private LocalDateTime accountDate;
    @Column(unique = true, nullable = false)
    private String email;

    @ManyToMany(mappedBy = "users",cascade = { CascadeType.PERSIST ,CascadeType.REMOVE})
    private List<Role> roles = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Vote> votes = new ArrayList<>();

    public User() {
        super();
    }

    public User(Long id, String name, String surname, String gender, String phone, String email, String password) {
        super(name, surname, gender, phone, email);
        this.id = id;
        this.password = password;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setUser(this);

    }

    private void addVote(Vote vote) {
        votes.add(vote);
        vote.setUser(this);
    }
    
    public void addRole(Role role){
        roles.add(role);
        role.addUser(this);
       
    }
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", password=" + password + ", accountDate=" + accountDate + "email" + getEmail();
    }
    
    
    
    public static void main(String args[]) {

    }

}
